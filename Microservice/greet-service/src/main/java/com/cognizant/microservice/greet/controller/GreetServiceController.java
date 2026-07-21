package com.cognizant.microservice.greet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetServiceController {
    @GetMapping("/greet/hello")
    public String hello() {
        return "Hello World";
    }
}
