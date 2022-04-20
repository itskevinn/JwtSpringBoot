package com.kevcode.jwtpractice.application.store.service;

import com.kevcode.jwtpractice.application.store.http.dto.AddressDto;
import com.kevcode.jwtpractice.application.store.http.request.AddressRequest;

public interface IAddressService {
    AddressDto save(AddressRequest addressRequest);

    AddressDto findById(Long id);


}
