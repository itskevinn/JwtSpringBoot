package com.kevcode.jwtpractice.application.security;

import com.kevcode.jwtpractice.application.security.service.UserDetailsServiceImpl;
import com.kevcode.jwtpractice.infrastructure.security.jwt.JwtEntryPoint;
import com.kevcode.jwtpractice.infrastructure.security.jwt.JwtTokenFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {
    UserDetailsServiceImpl userDetailsService;
    JwtEntryPoint entryPoint;

    public JwtTokenFilter jwtTokenFilter() {
        
    }
}
