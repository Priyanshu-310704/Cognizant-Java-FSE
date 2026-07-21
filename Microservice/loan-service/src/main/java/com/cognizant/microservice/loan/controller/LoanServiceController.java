package com.cognizant.microservice.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanServiceController {
    public record Loan(String number, String type, long loan, long emi, int tenure) {
    }

    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        return new Loan(number, "car", 400000L, 3258L, 18);
    }
}
