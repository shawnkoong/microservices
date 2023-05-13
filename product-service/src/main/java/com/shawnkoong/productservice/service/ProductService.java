package com.shawnkoong.productservice.service;

import com.shawnkoong.productservice.dto.ProductRequest;
import com.shawnkoong.productservice.dto.ProductResponse;
import com.shawnkoong.productservice.mapper.ProductResponseMapper;
import com.shawnkoong.productservice.model.Product;
import com.shawnkoong.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductResponseMapper::toProductResponse).toList();
    }
}
