package com.shawnkoong.orderservice.mapper;

import com.shawnkoong.orderservice.dto.OrderItemDTO;
import com.shawnkoong.orderservice.model.OrderItem;

public class OrderItemMapper {
    public static OrderItem toEntity(OrderItemDTO dto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setCode(dto.code());
        orderItem.setPrice(dto.price());
        orderItem.setQuantity(dto.quantity());
        return orderItem;
    }
}
