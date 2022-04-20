package com.kevcode.jwtpractice.domain.store.entity;

import com.kevcode.jwtpractice.domain.shared.EntityBase;

import javax.persistence.Entity;

@Entity
public class Product extends EntityBase {
    private String name;
    private Long price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
