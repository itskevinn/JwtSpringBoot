package com.kevcode.jwtpractice.application.security.http.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginUserRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
