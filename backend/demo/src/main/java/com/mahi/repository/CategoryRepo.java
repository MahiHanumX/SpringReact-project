package com.mahi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahi.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
