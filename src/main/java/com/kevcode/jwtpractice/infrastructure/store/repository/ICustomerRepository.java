package com.kevcode.jwtpractice.infrastructure.store.repository;

import com.kevcode.jwtpractice.domain.store.entity.people.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
