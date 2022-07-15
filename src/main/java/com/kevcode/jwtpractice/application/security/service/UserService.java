package com.kevcode.jwtpractice.application.security.service;

import com.kevcode.jwtpractice.application.security.http.dto.UserDto;
import com.kevcode.jwtpractice.application.security.http.request.UserRequest;
import com.kevcode.jwtpractice.application.shared.Response;
import com.kevcode.jwtpractice.application.store.exception.UserAlreadyExistsException;
import com.kevcode.jwtpractice.domain.security.entity.Role;
import com.kevcode.jwtpractice.domain.security.entity.User;
import com.kevcode.jwtpractice.domain.security.enums.RoleName;
import com.kevcode.jwtpractice.infrastructure.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class UserService implements IUserService {
    private final IUserRepository _userRepository;
    private final ModelMapper _modelMapper;
    private final PasswordEncoder _passwordEncoder;
    private final IRoleService _roleService;

    @Autowired
    public UserService(IUserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, IRoleService roleService) {
        _userRepository = userRepository;
        _modelMapper = modelMapper;
        _passwordEncoder = passwordEncoder;
        _roleService = roleService;
    }

    @Override
    public Response<UserDto> findByUsername(String username) {
        try {
            User user = _userRepository.findByUsername(username).orElse(null);
            if (user == null) new Response<>(null, HttpStatus.NO_CONTENT, "Usuario no encontrado");
            UserDto userDto = _modelMapper.map(user, UserDto.class);
            return new Response<>(userDto, HttpStatus.OK, "Usuario encontrado");
        } catch (Exception e) {
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un error", e);
        }
    }

    @Override
    public Response<Boolean> existsByUsername(String username) {
        try {
            boolean existByUsername = _userRepository.existsByUsername(username);
            if (!existByUsername) new Response<>(false, HttpStatus.NO_CONTENT, "Usuario no existe");
            return new Response<>(existByUsername, HttpStatus.OK, "Usuario existe");
        } catch (Exception e) {
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un error", e);
        }
    }

    @Override
    public Response<UserDto> save(UserRequest userRequest) throws UserAlreadyExistsException {
        try {
            User user = _modelMapper.map(userRequest, User.class);
            user.setPassword(_passwordEncoder.encode(user.getPassword()));
            user.setRoles(buildUserRoles(user.getRoles()));
            user = _userRepository.save(user);
            if (_userRepository.existsByUsername(user.getUsername())) {
                throw new UserAlreadyExistsException("Usuario ya existe");
            }
            UserDto userDto = _modelMapper.map(user, UserDto.class);
            return new Response<>(userDto, HttpStatus.OK, "Usuario creado");
        } catch (Exception e) {
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un error", e);
        }
    }

    private Set<Role> buildUserRoles(Set<Role> roles) {
        roles.add(_roleService.findByRoleName(RoleName.USER_ROLE));
        if (roles.contains("admin"))
            roles.add(_roleService.findByRoleName(RoleName.ADMIN_ROLE));
        return roles;
    }

    private String encryptPassword(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
