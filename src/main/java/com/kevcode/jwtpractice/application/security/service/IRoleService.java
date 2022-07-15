package com.kevcode.jwtpractice.application.security.service;

import com.kevcode.jwtpractice.application.security.http.dto.RoleDto;
import com.kevcode.jwtpractice.application.shared.Response;
import com.kevcode.jwtpractice.domain.security.entity.Role;
import com.kevcode.jwtpractice.domain.security.enums.RoleName;


public interface IRoleService {
   Role findByRoleName(RoleName roleName);
}
