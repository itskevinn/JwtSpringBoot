package com.kevcode.jwtpractice.application.store.service;

import com.kevcode.jwtpractice.application.shared.Response;
import com.kevcode.jwtpractice.application.store.exception.UserAlreadyExistsException;
import com.kevcode.jwtpractice.application.store.http.dto.CustomerDto;
import com.kevcode.jwtpractice.application.store.http.request.CustomerRequest;

public interface ICustomerService {
    Response<CustomerDto> save(CustomerRequest customerRequest) throws UserAlreadyExistsException;

    Response<CustomerDto> findById(Long id);
}
