package com.shawnkoong.orderservice.dto;

import java.math.BigDecimal;

public record OrderItemDTO(Long id, String code, BigDecimal price, int quantity) {
}
