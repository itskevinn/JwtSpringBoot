package com.kevcode.jwtpractice.application.store.http.dto;

import com.kevcode.jwtpractice.application.security.http.dto.UserDto;
import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String name;
    private String lastName;
    private UserDto userDto;
    private AddressDto addressDto;
    private ContactDto contactDto;
}
