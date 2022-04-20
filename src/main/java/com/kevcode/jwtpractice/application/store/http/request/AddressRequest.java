package com.kevcode.jwtpractice.application.store.http.request;

import lombok.Data;

@Data
public class AddressRequest {
    private String mainRoadType;
    private String mainRoadNumber;
    private String subRoadNumber;
    private String houseNumber;
    private String neighborhood;
    private String detail;
}
