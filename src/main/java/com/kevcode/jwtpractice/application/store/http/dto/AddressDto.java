package com.kevcode.jwtpractice.application.store.http.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String mainRoadType;
    private String mainRoadNumber;
    private String subRoadNumber;
    private String houseNumber;
    private String neighborhood;
    private String detail;
}
