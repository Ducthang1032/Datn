package com.poly.datn.be.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.datn.be.config.AuthConfig;
import com.poly.datn.be.constants.AuthoritiesConstants;
import com.poly.datn.be.dto.TokenInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@Slf4j
public class JwtTokenProvider {

    private final AuthConfig authConfig;

    @SneakyThrows
    public String generateToken(Authentication auth, Date expirationTime) {
        String subject = (new ObjectMapper()).writeValueAsString(new TokenInfo(auth.getName()));
        return Jwts.builder()
                .setSubject(subject)
                // Convert to list of strings.
                // This is important because it affects the way we get them back in the Gateway.
                .claim(AuthoritiesConstants.AUTHORITIES, auth.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS512, authConfig.getKeySecret().getBytes())
                .compact();
    }

    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(authConfig.getKeySecret().getBytes())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
