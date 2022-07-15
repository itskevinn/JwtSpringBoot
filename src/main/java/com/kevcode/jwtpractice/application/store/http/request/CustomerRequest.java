package com.kevcode.jwtpractice.application.store.http.request;

import com.kevcode.jwtpractice.application.security.http.request.UserRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    private UserRequest userRequest;
    private AddressRequest addressRequest;
    private ContactRequest contactRequest;
}
