package com.shawnkoong.inventoryservice.mapper;

import com.shawnkoong.inventoryservice.dto.InventoryRequest;
import com.shawnkoong.inventoryservice.model.Inventory;

public class InventoryRequestMapper {

    public static Inventory toEntity(InventoryRequest inventoryRequest) {
        return Inventory.builder()
                .code(inventoryRequest.code())
                .quantity(inventoryRequest.quantity())
                .build();
    }
}
