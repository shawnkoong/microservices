package com.shawnkoong.inventoryservice.service;

import com.shawnkoong.inventoryservice.dto.InventoryRequest;
import com.shawnkoong.inventoryservice.dto.InventoryResponse;
import com.shawnkoong.inventoryservice.mapper.InventoryReponseMapper;
import com.shawnkoong.inventoryservice.mapper.InventoryRequestMapper;
import com.shawnkoong.inventoryservice.model.Inventory;
import com.shawnkoong.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> codes) {
        return inventoryRepository.findByCodeIn(codes).stream()
                .map(InventoryReponseMapper::toInventoryResponse)
                .toList();
    }

    public void createInventoryItem(InventoryRequest inventoryRequest) {
        Inventory inventory = InventoryRequestMapper.toEntity(inventoryRequest);
        inventoryRepository.save(inventory);
    }
}
