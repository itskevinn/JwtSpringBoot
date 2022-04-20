package com.kevcode.jwtpractice.domain.store.entity;

import com.kevcode.jwtpractice.domain.shared.EntityBase;

import javax.persistence.Entity;

@Entity
public class Category extends EntityBase {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
