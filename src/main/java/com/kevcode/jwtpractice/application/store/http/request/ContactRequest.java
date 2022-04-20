package com.kevcode.jwtpractice.application.store.http.request;

import lombok.Data;

@Data
public class ContactRequest {
    private String phoneNumber;
    private String email;
}
