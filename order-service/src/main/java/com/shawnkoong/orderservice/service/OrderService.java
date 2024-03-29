package com.shawnkoong.orderservice.service;

import com.shawnkoong.orderservice.dto.InventoryResponse;
import com.shawnkoong.orderservice.dto.OrderRequest;
import com.shawnkoong.orderservice.event.OrderPlacedEvent;
import com.shawnkoong.orderservice.mapper.OrderItemMapper;
import com.shawnkoong.orderservice.model.Order;
import com.shawnkoong.orderservice.model.OrderItem;
import com.shawnkoong.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public String createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItem> orderItems = orderRequest.orderItemDTOs().stream()
                .map(OrderItemMapper::toEntity)
                .toList();
        order.setOrderItems(orderItems);

        List<String> codes = order.getOrderItems().stream()
                .map(OrderItem::getCode)
                .toList();

        // Call inventory-service to check if in stock
        InventoryResponse[] inventoryResponses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                    uriBuilder -> uriBuilder.queryParam("codes", codes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        if (allInStock) {
            orderRepository.save(order);
            kafkaTemplate.send("notificationTopic", new OrderPlacedEvent(order.getOrderNumber()));
            return "Order successfully created";
        } else {
            throw new IllegalArgumentException("Product out of stock");
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
