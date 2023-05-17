package com.shawnkoong.productservice.util;

import com.shawnkoong.productservice.model.Product;
import com.shawnkoong.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() < 1) {
            Product product = new Product();
            product.setName("GeForce RTX 4070 12GB FE");
            product.setDescription("Get equipped for stellar gaming and creating with the NVIDIA GeForce RTX 4070. It’s built with the ultra-efficient NVIDIA Ada Lovelace architecture. Experience fast ray tracing, AI-accelerated performance with DLSS 3, new ways to create, and much more.");
            product.setPrice(BigDecimal.valueOf(599.99));
            productRepository.save(product);
        }
    }
}
