package com.kevcode.jwtpractice.application.store.http.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddressRequest {
    @NotBlank
    private String mainRoadType;
    @NotBlank
    private String mainRoadNumber;
    @NotBlank
    private String subRoadNumber;
    @NotBlank
    private String houseNumber;
    @NotBlank
    private String neighborhood;
    private String detail;
}
