package com.kevcode.jwtpractice.infrastructure.security.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtProvider _jwtProvider;

    @Autowired
    public JwtTokenFilter(JwtProvider jwtProvider) {
        _jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String token = this.getToken(request);
            if (token != null && _jwtProvider.validateToken(token)) {

            }
        } catch (Exception e) {
            throw e;
        }
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            return header.replace("Bearer ", "");
        }
        return null;
    }
}
