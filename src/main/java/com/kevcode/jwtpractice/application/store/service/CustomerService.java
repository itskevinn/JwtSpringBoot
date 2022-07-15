package com.kevcode.jwtpractice.application.store.service;

import com.kevcode.jwtpractice.application.security.service.IUserService;
import com.kevcode.jwtpractice.application.shared.Response;
import com.kevcode.jwtpractice.application.store.exception.UserAlreadyExistsException;
import com.kevcode.jwtpractice.application.store.http.dto.AddressDto;
import com.kevcode.jwtpractice.application.store.http.dto.CustomerDto;
import com.kevcode.jwtpractice.application.store.http.request.CustomerRequest;
import com.kevcode.jwtpractice.domain.store.entity.people.Customer;
import com.kevcode.jwtpractice.infrastructure.store.repository.ICustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService implements ICustomerService {
    private final ICustomerRepository _customerRepository;
    private final IUserService _userService;
    private final IContactService _contactService;
    private final IAddressService _addressService;
    private final ModelMapper _modelMapper;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository,
                           IUserService userService,
                           IContactService contactService,
                           IAddressService addressService,
                           ModelMapper modelMapper) {
        _customerRepository = customerRepository;
        _userService = userService;
        _contactService = contactService;
        _addressService = addressService;
        _modelMapper = modelMapper;
    }

    @Override
    public Response<CustomerDto> save(CustomerRequest customerRequest, BindingResult bindingResult) throws UserAlreadyExistsException {
        try {
            if (bindingResult.hasErrors()) return new Response<>(null, HttpStatus.BAD_REQUEST, "Revise los datos");
            Customer customer = _modelMapper.map(customerRequest, Customer.class);
            _userService.save(customerRequest.getUserRequest());
            _addressService.save(customerRequest.getAddressRequest());
            _contactService.save(customerRequest.getContactRequest());
            customer = _customerRepository.save(customer);
            CustomerDto customerDto = _modelMapper.map(customer, CustomerDto.class);
            return new Response<>(customerDto, HttpStatus.OK, "Cliente guardado");
        } catch (Exception e) {
            if (e.getClass() == UserAlreadyExistsException.class) throw new UserAlreadyExistsException();
            return new Response<>(null, HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error", e);
        }
    }

    @Override
    public Response<CustomerDto> findById(Long id) {
        Customer customer = _customerRepository.findById(id).orElse(null);
        CustomerDto customerDto = _modelMapper.map(customer, CustomerDto.class);
        return new Response<>(customerDto, HttpStatus.OK, "Cliente consultado");
    }
}
