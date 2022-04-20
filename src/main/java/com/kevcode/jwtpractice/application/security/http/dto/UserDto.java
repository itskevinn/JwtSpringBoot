package com.kevcode.jwtpractice.application.security.http.dto;

import com.kevcode.jwtpractice.domain.security.entity.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
public class UserDto {
    private String username;
    private Set<Role> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
