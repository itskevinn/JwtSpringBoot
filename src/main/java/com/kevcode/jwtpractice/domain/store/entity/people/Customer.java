package com.kevcode.jwtpractice.domain.store.entity.people;

import com.kevcode.jwtpractice.domain.security.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends Person {
    @ManyToMany
    @JoinTable(name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses;
    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
