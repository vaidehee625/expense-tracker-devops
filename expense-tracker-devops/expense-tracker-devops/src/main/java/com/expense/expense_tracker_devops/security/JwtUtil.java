package com.expense.expense_tracker_devops.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.springframework.stereotype.Component;

import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@Component
public class JwtUtil {

    private final String SECRET_KEY =
            "expense_tracker_secret_key_2026_secure_project";

    public String generateToken(String email) {

        Key hmacKey = new SecretKeySpec(SECRET_KEY.getBytes(), "HmacSHA256");

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(hmacKey)
                .compact();

    }

    public String extractEmail(String token) {

        return extractClaims(token)
                .getSubject();

    }

    public boolean isTokenValid(
            String token,
            String email
    ) {

        final String extractedEmail =
                extractEmail(token);

        return extractedEmail.equals(email)
                && !isTokenExpired(token);

    }

    private boolean isTokenExpired(String token) {

        return extractClaims(token)
                .getExpiration()
                .before(new Date());

    }

    private Claims extractClaims(String token) {

        Key hmacKey = new SecretKeySpec(SECRET_KEY.getBytes(), "HmacSHA256");

        return Jwts.parser()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

}