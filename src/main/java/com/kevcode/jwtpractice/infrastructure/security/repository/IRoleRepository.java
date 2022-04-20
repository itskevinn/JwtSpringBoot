package com.kevcode.jwtpractice.infrastructure.security.repository;

import com.kevcode.jwtpractice.domain.security.entity.Role;
import com.kevcode.jwtpractice.domain.security.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
