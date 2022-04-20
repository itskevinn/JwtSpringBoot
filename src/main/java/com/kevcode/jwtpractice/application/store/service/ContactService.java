package com.kevcode.jwtpractice.application.store.service;

import com.kevcode.jwtpractice.application.store.http.dto.ContactDto;
import com.kevcode.jwtpractice.application.store.http.request.ContactRequest;
import com.kevcode.jwtpractice.domain.store.entity.people.Contact;
import com.kevcode.jwtpractice.infrastructure.store.repository.IContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ContactService implements IContactService {
    private final IContactRepository _contactRepository;
    private final ModelMapper _modelMapper;

    @Autowired
    public ContactService(IContactRepository contactRepository,
                          ModelMapper modelMapper) {
        _contactRepository = contactRepository;
        _modelMapper = modelMapper;
    }

    @Override
    public ContactDto save(ContactRequest contactRequest) {
        Contact contact = _modelMapper.map(contactRequest, Contact.class);
        contact = _contactRepository.save(contact);
        return _modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public ContactDto findById(Long id) {
        return null;
    }


}
