package com.example.project.service.jwt;

import com.example.project.login.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final RedisTemplate<String, String> redisTemplate;
    private final JwtUtil jwtUtil;

    public Map<String, String> generateAndStoreTokens(String username) {
        String accessToken = jwtUtil.generateAccessToken(username);
        String refreshToken = jwtUtil.generateRefreshToken(username);

        redisTemplate.opsForValue().set("ACCESS:" + username, accessToken, 15, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set("REFRESH:" + username, refreshToken, 1, TimeUnit.DAYS);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);
        return tokens;
    }

    public boolean validateAccessToken(String username, String token) {
        String storedToken = redisTemplate.opsForValue().get("ACCESS:" + username);
        return storedToken != null && storedToken.equals(token) && jwtUtil.validateToken(token);
    }

    public String refreshAccessToken(String username, String refreshToken) {
        String storedRefresh = redisTemplate.opsForValue().get("REFRESH:" + username);
        if (storedRefresh != null && storedRefresh.equals(refreshToken) && jwtUtil.validateToken(refreshToken)) {
            return jwtUtil.generateAccessToken(username);
        }
        throw new RuntimeException("Invalid refresh token");
    }
}

