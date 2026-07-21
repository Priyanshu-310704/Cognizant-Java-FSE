package com.cognizant.microservice.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutes {
    @Bean
    RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("account-route", r -> r.path("/bank/accounts/**")
                        .filters(f -> f.rewritePath("/bank/(?<segment>.*)", "/${segment}"))
                        .uri("lb://account-service"))
                .route("loan-route", r -> r.path("/bank/loans/**")
                        .filters(f -> f.rewritePath("/bank/(?<segment>.*)", "/${segment}"))
                        .uri("lb://loan-service"))
                .route("greet-route", r -> r.path("/greet/**")
                        .uri("lb://greet-service"))
                .route("customer-route", r -> r.path("/customer-api/**")
                        .filters(f -> f.rewritePath("/customer-api/(?<segment>.*)", "/customers/${segment}"))
                        .uri("lb://customer-service"))
                .route("billing-route", r -> r.path("/billing-api/**")
                        .filters(f -> f.rewritePath("/billing-api/(?<segment>.*)", "/bills/${segment}"))
                        .uri("lb://billing-service"))
                .route("payment-route", r -> r.path("/payments/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("paymentCircuitBreaker").setFallbackUri("forward:/fallback/payment")))
                        .uri("lb://payment-service"))
                .build();
    }
}
