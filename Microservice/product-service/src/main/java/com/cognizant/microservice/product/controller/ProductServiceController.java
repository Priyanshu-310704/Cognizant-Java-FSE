package com.cognizant.microservice.product.controller;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final String defaultCurrency;

    public ProductServiceController(@Value("${catalog.default-currency:INR}") String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
        products.put(1L, new Product(1, "Laptop", 15, defaultCurrency));
        products.put(2L, new Product(2, "Phone", 30, defaultCurrency));
    }

    @GetMapping("/products")
    public Collection<Product> all() {
        return products.values();
    }

    @GetMapping("/products/{id}")
    public Product get(@PathVariable long id) {
        return products.get(id);
    }

    @PostMapping("/products")
    public Product create(@RequestBody Product product) {
        products.put(product.id(), product);
        return product;
    }

    public record Product(long id, String name, int stock, String currency) {
    }
}
