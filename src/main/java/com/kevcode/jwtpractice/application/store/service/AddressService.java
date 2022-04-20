package com.kevcode.jwtpractice.application.store.service;

import com.kevcode.jwtpractice.application.store.http.dto.AddressDto;
import com.kevcode.jwtpractice.application.store.http.request.AddressRequest;
import com.kevcode.jwtpractice.domain.store.entity.people.Address;
import com.kevcode.jwtpractice.infrastructure.store.repository.IAddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService implements IAddressService {
    private final IAddressRepository _addressRepository;
    private final ModelMapper _modelMapper;

    @Autowired
    public AddressService(IAddressRepository addressRepository,
                          ModelMapper modelMapper) {
        _addressRepository = addressRepository;
        _modelMapper = modelMapper;
    }

    @Override
    public AddressDto save(AddressRequest addressRequest) {
        Address address = _modelMapper.map(addressRequest, Address.class);
        address = _addressRepository.save(address);
        return _modelMapper.map(address, AddressDto.class);
    }

    @Override
    public AddressDto findById(Long id) {
        return null;
    }
}
