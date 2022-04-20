package com.kevcode.jwtpractice.domain.security.entity;

import com.kevcode.jwtpractice.domain.security.enums.RoleName;
import com.kevcode.jwtpractice.domain.shared.EntityBase;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "APP_ROLE")
public class Role extends EntityBase {
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role() {
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
