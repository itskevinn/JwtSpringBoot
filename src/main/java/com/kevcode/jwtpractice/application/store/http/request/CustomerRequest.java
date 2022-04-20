package com.kevcode.jwtpractice.application.store.http.request;

import com.kevcode.jwtpractice.application.security.http.request.UserRequest;
import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String lastName;
    private UserRequest userRequest;
    private AddressRequest addressRequest;
    private ContactRequest contactRequest;
}
