package com.example.DEAproject.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    private static final String SECRET_KEY ="kssSnkXKSWJqrgS8nmXOGF1uY7xIQ6hJfGJyOaREgR/HOrJDDHpjsei5jLLFOzn22mXsj4vB3y4FSE0vKXKTnapWrG3sKBaHYSpdtTL9bX8=";
    public String extractUsername(String token) {
        return null;
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.
                parserBuilder().
                setSigningKey(getSignInKey()).
                build().
                parseClaimsJws(token).
                getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
