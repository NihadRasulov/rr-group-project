package com.example.project.service.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return value != null ? value.toString() : "Key not found";
    }

    public Map<String, String> getAll() {
        Set<String> keys = redisTemplate.keys("*");
        Map<String, String> result = new HashMap<>();
        if (keys != null) {
            for (String key : keys) {
                Object value = redisTemplate.opsForValue().get(key);
                result.put(key, value != null ? value.toString() : "null");
            }
        }
        return result;
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
