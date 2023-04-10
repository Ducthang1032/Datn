package com.poly.datn.be.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AuthConfig {
    @Value("${app.security.key-secret}")
    private String keySecret;

    @Value("${app.security.expiration-token}")
    private Long expirationToken;

    @Value("${app.security.ignore-auth-api}")
    private String[] ignoreAuthApi;

    @Value("${app.cipher.encrypt-key}")
    private String cipherSecretKey;
}
