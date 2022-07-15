package com.kevcode.jwtpractice.application.security.service;

import com.kevcode.jwtpractice.domain.security.entity.Role;
import com.kevcode.jwtpractice.domain.security.enums.RoleName;
import com.kevcode.jwtpractice.infrastructure.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service

public class RoleService implements IRoleService {
    private final IRoleRepository _roleRepository;

    @Autowired
    public RoleService(IRoleRepository roleRepository) {
        _roleRepository = roleRepository;
    }

    @Override
    public Role findByRoleName(RoleName roleName) {
        try {
            return _roleRepository.findByRoleName(roleName).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
}
