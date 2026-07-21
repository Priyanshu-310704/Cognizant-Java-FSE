package com.cognizant.microservice.inventory.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryServiceController {
    private final Map<Long, StockLevel> inventory = new ConcurrentHashMap<>();
    private final int reorderLevel;

    public InventoryServiceController(@Value("${inventory.default-reorder-level:10}") int reorderLevel) {
        this.reorderLevel = reorderLevel;
        inventory.put(1L, new StockLevel(1, 15, false));
        inventory.put(2L, new StockLevel(2, 4, true));
    }

    @GetMapping("/inventory/{productId}")
    public StockLevel get(@PathVariable long productId) {
        StockLevel stock = inventory.get(productId);
        return new StockLevel(productId, stock.availableQuantity(), stock.availableQuantity() <= reorderLevel);
    }

    @PostMapping("/inventory")
    public StockLevel update(@RequestBody StockLevel stockLevel) {
        StockLevel evaluated = new StockLevel(stockLevel.productId(), stockLevel.availableQuantity(), stockLevel.availableQuantity() <= reorderLevel);
        inventory.put(evaluated.productId(), evaluated);
        return evaluated;
    }

    public record StockLevel(long productId, int availableQuantity, boolean reorderRequired) {
    }
}
