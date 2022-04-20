package com.kevcode.jwtpractice.domain.store.entity.people;

import com.kevcode.jwtpractice.domain.shared.EntityBase;

import javax.persistence.*;

@MappedSuperclass
public abstract class Person extends EntityBase {
    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
