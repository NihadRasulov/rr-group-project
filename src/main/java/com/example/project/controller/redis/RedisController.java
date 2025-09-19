package com.example.project.controller.redis;

import com.example.project.service.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/set")
    public String save(@RequestPart String key, @RequestPart String value) {
        redisService.set(key, value);
        return "Saved: " + key + " -> " + value;
    }

    @GetMapping("/get")
    public String get(@RequestPart String key) {
        return "Key: " + key + "-> " + "Value" + redisService.get(key);
    }

    @GetMapping("/getAll")
    public Map<String, String> getAllValues() {
        return redisService.getAll();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestPart String key) {
        redisService.delete(key);
        return "Deleted key: " + key;
    }
}
