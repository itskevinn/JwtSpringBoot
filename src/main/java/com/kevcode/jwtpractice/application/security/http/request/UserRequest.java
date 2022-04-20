package com.kevcode.jwtpractice.application.security.http.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
}
