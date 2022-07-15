package com.kevcode.jwtpractice.api.controllers.security;

import com.kevcode.jwtpractice.application.security.service.IRoleService;
import com.kevcode.jwtpractice.application.security.service.IUserService;
import com.kevcode.jwtpractice.infrastructure.security.jwt.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    private final AuthenticationManager _authenticationManager;
    private final IUserService _userService;
    private final JwtProvider _jwtProvider;

    public AuthController(AuthenticationManager authenticationManager,
                          IUserService userService,
                          JwtProvider jwtProvider) {
        _authenticationManager = authenticationManager;
        _userService = userService;
        _jwtProvider = jwtProvider;
    }

}
