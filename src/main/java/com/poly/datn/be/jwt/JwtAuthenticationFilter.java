//package com.poly.datn.be.jwt;
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    @Autowired
//    private JwtTokenProvider tokenProvider;
//
//    @SneakyThrows
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
//        try {
//            // Lấy jwt từ request
//            String bearerToken = request.getHeader("Authorization");
//
//            String jwt = getJwtFromRequest(request);
//
//            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
//                // Lấy id user từ chuỗi jwt
//                String username = tokenProvider.getUsernameFromJWT(jwt);
//                // Lấy thông tin người dùng từ id
//            }
//        } catch (Exception ex) {
//            log.error("Failed on set user authentication", ex);
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        // Kiểm tra xem header Authorization có chứa thông tin jwt không
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//}
