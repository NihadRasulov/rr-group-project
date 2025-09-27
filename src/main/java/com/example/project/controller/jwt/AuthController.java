package com.example.project.controller.jwt;

import com.example.project.dto.login.LoginRequest;
import com.example.project.model.login.UserEntity;
import com.example.project.repository.login.UserRepository;
import com.example.project.service.jwt.TokenService;
import com.example.project.service.jwt.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(request.getUsername());

        if (userEntity.isEmpty()) {
            throw new RuntimeException("This user not found!" + request.getUsername());
        }
        if(!passwordEncoder.matches(request.getPassword(),userEntity.get().getPassword())) {
            throw new RuntimeException("Invalid password ");
        }
        return ResponseEntity.ok(tokenService.generateAndStoreTokens(request.getUsername()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequest request) {
        UserEntity user = userService.register(request);
        return ResponseEntity.ok("User registered: " + user.getUsername());
    }
}
