package com.shawnkoong.inventoryservice.repository;

import com.shawnkoong.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByCodeIn(List<String> codes);
}
