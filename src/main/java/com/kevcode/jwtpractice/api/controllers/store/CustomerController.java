package com.kevcode.jwtpractice.api.controllers.store;

import com.kevcode.jwtpractice.application.shared.Response;
import com.kevcode.jwtpractice.application.store.exception.UserAlreadyExistsException;
import com.kevcode.jwtpractice.application.store.http.dto.CustomerDto;
import com.kevcode.jwtpractice.application.store.http.request.CustomerRequest;
import com.kevcode.jwtpractice.application.store.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
    private final ICustomerService _customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        _customerService = customerService;
    }

    @PostMapping("/Create")
    public Response<CustomerDto> save(@RequestBody CustomerRequest customerRequest) throws UserAlreadyExistsException {
        return _customerService.save(customerRequest);
    }
}
