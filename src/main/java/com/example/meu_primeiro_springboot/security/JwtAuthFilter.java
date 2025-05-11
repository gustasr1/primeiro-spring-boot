package com.example.meu_primeiro_springboot.security;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserDetailsService  userDetailsService;

    public JwtAuthFilter(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String authHeader = request.getHeader("Autorization");
        if (authHeader == null || !authHeader.startsWith("bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        String username = JwtUtil.extractUsername(token);

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userdetails = userDetailsService.loadUserByUsername("username");
            if (JwtUtil.validateToken(token)) {
                UsernamePasswordAuthenticationFilter
            }
        }

     }
    
}
