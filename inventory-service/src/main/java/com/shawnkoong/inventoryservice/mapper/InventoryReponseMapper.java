package com.shawnkoong.inventoryservice.mapper;

import com.shawnkoong.inventoryservice.dto.InventoryResponse;
import com.shawnkoong.inventoryservice.model.Inventory;

public class InventoryReponseMapper {

    public static InventoryResponse toInventoryResponse(Inventory inventory) {
        return new InventoryResponse(inventory.getCode(), inventory.getQuantity() > 0);
    }
}
