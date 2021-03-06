package com.kevcode.jwtpractice.domain.store.entity.people;

import com.kevcode.jwtpractice.domain.shared.EntityBase;

import javax.persistence.Entity;

@Entity
public class Contact extends EntityBase {
    private String phoneNumber;
    private String email;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
