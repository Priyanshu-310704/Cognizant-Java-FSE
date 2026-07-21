package com.cognizant.microservice.securitylab.controller;

import com.cognizant.microservice.securitylab.service.JwtTokenService;
import java.security.Principal;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityLabController {
    private final JwtTokenService jwtTokenService;

    public SecurityLabController(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of("message", "Security lab is running");
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/oidc-user")
    public Map<String, Object> oidcUser(@AuthenticationPrincipal OidcUser user) {
        return Map.of("subject", user.getSubject(), "claims", user.getClaims());
    }

    @GetMapping("/token/{username}")
    public Map<String, String> token(@PathVariable String username) {
        return Map.of("token", jwtTokenService.createToken(username));
    }

    @GetMapping("/secure")
    public Map<String, String> secure() {
        return Map.of("message", "This is a secure endpoint");
    }
}
