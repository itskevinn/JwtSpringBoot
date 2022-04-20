package com.kevcode.jwtpractice.domain.store.entity.people;


import com.kevcode.jwtpractice.domain.shared.EntityBase;

import javax.persistence.Entity;

@Entity
public class Address extends EntityBase {
    private String mainRoadType;
    private String mainRoadNumber;
    private String subRoadNumber;
    private String houseNumber;
    private String neighborhood;
    private String detail;

    public String getMainRoadType() {
        return mainRoadType;
    }

    public void setMainRoadType(String mainRoadType) {
        this.mainRoadType = mainRoadType;
    }

    public String getMainRoadNumber() {
        return mainRoadNumber;
    }

    public void setMainRoadNumber(String mainRoadNumber) {
        this.mainRoadNumber = mainRoadNumber;
    }

    public String getSubRoadNumber() {
        return subRoadNumber;
    }

    public void setSubRoadNumber(String subRoadNumber) {
        this.subRoadNumber = subRoadNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
