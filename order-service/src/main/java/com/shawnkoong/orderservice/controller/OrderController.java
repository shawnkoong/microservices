package com.shawnkoong.orderservice.controller;

import com.shawnkoong.orderservice.dto.OrderRequest;
import com.shawnkoong.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest);
    }
}
