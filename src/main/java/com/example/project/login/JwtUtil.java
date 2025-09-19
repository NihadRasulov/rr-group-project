package com.example.project.login;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey secret = Keys.hmacShaKeyFor(
            "abbldafnvldaslknvaw35098u74y209gbawjlbaut4q8tgh;wigbty90ngfoewht40iputihng3gni3a409niOGNJARGMGLNA'PAIH4GAIONAWJNjnoslkneflkbnklsergknbsakoj;nr';kfndlknaslnkalkndfml bflanbnljfebnlafdnl"
                    .getBytes(StandardCharsets.UTF_8)
    );
    private final long accessTokenValidity = 1000 * 60 * 15; // 15 min
    private final long refreshTokenValidity = 1000 * 60 * 60 * 24; // 1 day

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenValidity))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenValidity))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
