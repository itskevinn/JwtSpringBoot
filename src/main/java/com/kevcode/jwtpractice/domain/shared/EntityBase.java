package com.kevcode.jwtpractice.domain.shared;

import javax.persistence.*;

@MappedSuperclass
public class EntityBase {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
