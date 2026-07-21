package com.cognizant.microservice.payment.controller;

import com.cognizant.microservice.payment.service.PaymentService;
import com.cognizant.microservice.payment.service.PaymentService.PaymentResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payments/{id}")
    public PaymentResult pay(@PathVariable long id) {
        return paymentService.pay(id);
    }
}
