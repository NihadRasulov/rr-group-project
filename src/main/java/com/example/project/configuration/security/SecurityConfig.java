package com.example.project.configuration.security;

import com.example.project.login.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())

                // Public endpoints
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("api/v1/auth/**",
                                         "api/v1/login/**",
                                         "api/v1/login",
                                        "api/v1/news/**").permitAll()       // login & refresh
                        .requestMatchers("/swagger-ui/**",
                                         "/swagger-ui.html",
                                         "/v3/api-docs/**").permitAll() // Swagger access without popup
                        .anyRequest().authenticated()                  // all other endpoints need JWT
                )

                // No Basic Auth popup
                .httpBasic(Customizer.withDefaults())

                // Add JWT filter for API requests
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
