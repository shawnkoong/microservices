package com.shawnkoong.inventoryservice.util;

import com.shawnkoong.inventoryservice.model.Inventory;
import com.shawnkoong.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Inventory inventory = new Inventory();
        inventory.setCode("msi_rtx_4080");
        inventory.setQuantity(100);
        inventoryRepository.save(inventory);

        Inventory inventory1 = new Inventory();
        inventory1.setCode("msi_rtx_4070_fe");
        inventory1.setQuantity(200);
        inventoryRepository.save(inventory1);
    }
}
