package com.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private static final String SECRET = "cognizant-spring-learn-secret-key-2026";
    private static final long EXPIRY_MILLIS = 1_200_000;
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String user) {
        Date now = new Date();
        return Jwts.builder()
                .subject(user)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + EXPIRY_MILLIS))
                .signWith(key)
                .compact();
    }

    public String getSubject(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }
}
