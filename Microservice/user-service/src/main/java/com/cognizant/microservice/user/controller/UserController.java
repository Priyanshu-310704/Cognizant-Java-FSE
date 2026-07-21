package com.cognizant.microservice.user.controller;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final Map<Long, User> users = new ConcurrentHashMap<>();

    public UserController() {
        users.put(1L, new User(1, "Asha Rao", "asha@example.com"));
        users.put(2L, new User(2, "Vikram Singh", "vikram@example.com"));
    }

    @GetMapping("/users")
    public Collection<User> all() {
        return users.values();
    }

    @GetMapping("/users/{id}")
    public User get(@PathVariable long id) {
        return users.get(id);
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        users.put(user.id(), user);
        return user;
    }

    public record User(long id, String name, String email) {
    }
}
