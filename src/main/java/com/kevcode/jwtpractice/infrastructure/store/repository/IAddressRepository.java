package com.kevcode.jwtpractice.infrastructure.store.repository;

import com.kevcode.jwtpractice.domain.store.entity.people.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
