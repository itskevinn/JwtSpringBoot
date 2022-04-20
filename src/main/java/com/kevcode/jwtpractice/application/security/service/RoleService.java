package com.kevcode.jwtpractice.application.security.service;

import com.kevcode.jwtpractice.application.security.http.dto.RoleDto;
import com.kevcode.jwtpractice.application.shared.Response;
import com.kevcode.jwtpractice.domain.security.entity.Role;
import com.kevcode.jwtpractice.domain.security.enums.RoleName;
import com.kevcode.jwtpractice.infrastructure.security.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Response<RoleDto> findByRoleName(RoleName roleName) {
        try {
            Role role = _roleRepository.findByRoleName(roleName).orElse(null);
            RoleDto roleDto = new RoleDto();
            if (role == null) return new Response<>(null, HttpStatus.NO_CONTENT, " Rol no encontrado");
            roleDto.setRoleName(role.getRoleName().name());
            return new Response<>(roleDto, HttpStatus.OK, "Rol no encontrado");
        } catch (Exception e) {
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error", e);
        }
    }
}
