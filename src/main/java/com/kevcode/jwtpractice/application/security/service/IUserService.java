package com.kevcode.jwtpractice.application.security.service;

import com.kevcode.jwtpractice.application.security.http.dto.UserDto;
import com.kevcode.jwtpractice.application.security.http.request.UserRequest;
import com.kevcode.jwtpractice.application.shared.Response;
import com.kevcode.jwtpractice.application.store.exception.UserAlreadyExistsException;


public interface IUserService {
    Response<UserDto> findByUsername(String username);

    Response<Boolean> existsByUsername(String username);

    Response<UserDto> save(UserRequest userRequest) throws UserAlreadyExistsException;
}
