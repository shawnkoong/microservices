package com.shawnkoong.productservice.mapper;

import com.shawnkoong.productservice.dto.ProductResponse;
import com.shawnkoong.productservice.model.Product;

public class ProductResponseMapper {
    public static ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
