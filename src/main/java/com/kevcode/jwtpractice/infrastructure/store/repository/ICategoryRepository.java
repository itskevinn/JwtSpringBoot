package com.kevcode.jwtpractice.infrastructure.store.repository;

import com.kevcode.jwtpractice.domain.store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
