package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.security.JwtService;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private final JwtService jwtService;

    public AuthenticationController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("Authorization header: {}", authHeader);
        String user = getUser(authHeader);
        String token = jwtService.generateToken(user);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        LOGGER.info("End");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes, StandardCharsets.UTF_8);
        String user = decodedCredentials.substring(0, decodedCredentials.indexOf(':'));
        LOGGER.debug("User: {}", user);
        return user;
    }
}
