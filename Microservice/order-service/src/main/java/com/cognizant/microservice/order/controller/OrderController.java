package com.cognizant.microservice.order.controller;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class OrderController {
    private final Map<Long, Order> orders = new ConcurrentHashMap<>();
    private final WebClient webClient;
    private final String userServiceBaseUrl;

    public OrderController(WebClient webClient, @Value("${user-service.base-url}") String userServiceBaseUrl) {
        this.webClient = webClient;
        this.userServiceBaseUrl = userServiceBaseUrl;
        orders.put(101L, new Order(101, 1, "Laptop", 75000));
        orders.put(102L, new Order(102, 2, "Phone", 35000));
    }

    @GetMapping("/orders")
    public Collection<Order> all() {
        return orders.values();
    }

    @PostMapping("/orders")
    public Order create(@RequestBody Order order) {
        orders.put(order.id(), order);
        return order;
    }

    @GetMapping("/orders/{id}/with-user")
    public Mono<OrderWithUser> getOrderWithUser(@PathVariable long id) {
        Order order = orders.get(id);
        return webClient.get()
                .uri(userServiceBaseUrl + "/users/" + order.userId())
                .retrieve()
                .bodyToMono(User.class)
                .map(user -> new OrderWithUser(order, user));
    }

    public record Order(long id, long userId, String item, double amount) {
    }

    public record User(long id, String name, String email) {
    }

    public record OrderWithUser(Order order, User user) {
    }
}
