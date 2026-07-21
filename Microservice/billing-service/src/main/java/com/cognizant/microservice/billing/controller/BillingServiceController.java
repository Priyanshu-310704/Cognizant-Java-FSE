package com.cognizant.microservice.billing.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingServiceController {
    public record Bill(long id, long customerId, double amount, String status) {
    }

    @GetMapping("/bills")
    public List<Bill> all() {
        return List.of(new Bill(101, 1, 2450.00, "PAID"), new Bill(102, 2, 899.00, "DUE"));
    }

    @GetMapping("/bills/{id}")
    public Bill get(@PathVariable long id) {
        return new Bill(id, 1, 2450.00, "PAID");
    }
}
