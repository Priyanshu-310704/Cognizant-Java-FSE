package com.cognizant.microservice.customer.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerServiceController {
    public record Customer(long id, String name, String tier) {
    }

    @GetMapping("/customers")
    public List<Customer> all() {
        return List.of(new Customer(1, "Asha Rao", "gold"), new Customer(2, "Vikram Singh", "silver"));
    }

    @GetMapping("/customers/{id}")
    public Customer get(@PathVariable long id) {
        return new Customer(id, "Asha Rao", "gold");
    }
}
