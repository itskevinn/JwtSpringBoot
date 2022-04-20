package com.kevcode.jwtpractice.application.store.service;

import com.kevcode.jwtpractice.application.store.http.dto.ContactDto;
import com.kevcode.jwtpractice.application.store.http.request.ContactRequest;

public interface IContactService {
    ContactDto save(ContactRequest contactRequest);

    ContactDto findById(Long id);

}
