package com.kevcode.jwtpractice.infrastructure.store.repository;

import com.kevcode.jwtpractice.domain.store.entity.people.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContactRepository extends JpaRepository<Contact, Long> {

}
