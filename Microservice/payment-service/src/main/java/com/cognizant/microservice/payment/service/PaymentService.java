package com.cognizant.microservice.payment.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    @CircuitBreaker(name = "paymentGateway", fallbackMethod = "fallbackPayment")
    public PaymentResult pay(long paymentId) {
        throw new IllegalStateException("Third-party payment API timed out");
    }

    public PaymentResult fallbackPayment(long paymentId, Throwable throwable) {
        LOGGER.warn("Fallback executed for payment {} because {}", paymentId, throwable.getMessage());
        return new PaymentResult(paymentId, "PENDING", "Fallback response: payment will be retried");
    }

    public record PaymentResult(long paymentId, String status, String message) {
    }
}
