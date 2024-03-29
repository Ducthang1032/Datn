package com.poly.datn.be.security;

import com.poly.datn.be.errors.CustomBadCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomAuthenticationManager {
    private final AuthenticationManager authenticationManager;

    public Authentication authenticate(Authentication authentication) {
        try {
            return authenticationManager.authenticate(authentication);
        } catch (AuthenticationException authenticationException) {
            if (authenticationException instanceof BadCredentialsException)
                throw new CustomBadCredentialsException(authenticationException.getMessage(), String.valueOf(authentication.getPrincipal()));
            else throw authenticationException;
        }
    }
}
