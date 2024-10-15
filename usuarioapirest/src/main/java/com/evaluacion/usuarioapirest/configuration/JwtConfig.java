package com.evaluacion.usuarioapirest.configuration;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.SecretKey;
import java.util.Base64;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JwtDecoder jwtDecoder() {
        byte[] decodedKey = Base64.getDecoder().decode(secret);
        SecretKey key = Keys.hmacShaKeyFor(decodedKey);
        return NimbusJwtDecoder.withSecretKey(key).build();
    }
}
