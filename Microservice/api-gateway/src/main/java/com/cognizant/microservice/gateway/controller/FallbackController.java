package com.cognizant.microservice.gateway.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @GetMapping("/fallback/payment")
    public Mono<Map<String, String>> paymentFallback() {
        return Mono.just(Map.of("status", "fallback", "message", "Payment service is temporarily unavailable"));
    }
}
