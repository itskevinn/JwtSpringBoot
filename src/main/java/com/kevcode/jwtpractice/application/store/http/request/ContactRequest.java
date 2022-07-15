package com.kevcode.jwtpractice.application.store.http.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class ContactRequest {
    private String phoneNumber;
    @Email
    @NotBlank
    private String email;
}
