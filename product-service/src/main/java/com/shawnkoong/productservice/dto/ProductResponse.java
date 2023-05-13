package com.shawnkoong.productservice.dto;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, BigDecimal price) {
}
