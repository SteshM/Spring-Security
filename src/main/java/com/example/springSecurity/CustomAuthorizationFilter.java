package com.example.springSecurity;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CustomAuthorizationFilter extends OncePerRequestFilter {
    Logger logger = LoggerFactory.getLogger(CustomAuthorizationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
String authorizationHeader = request.getHeader("Authorization");
if(request.getServletPath().equals("/login") ||request.getServletPath().equals("/register")){
    filterChain.doFilter(request, response);
}else{
    if(authorizationHeader == null){
        logger.warn("no token provided");
    }else{
        if(authorizationHeader.startsWith("Bearer ")){
            String token = authorizationHeader.substring("Bearer ".length());

        }else{
            logger.warn("the token provided is not a bearer token");
        }
    }
}
    }
}
