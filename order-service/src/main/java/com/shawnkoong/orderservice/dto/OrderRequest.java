package com.shawnkoong.orderservice.dto;

import java.util.List;

public record OrderRequest(List<OrderItemDTO> orderItemDTOS) {
}
