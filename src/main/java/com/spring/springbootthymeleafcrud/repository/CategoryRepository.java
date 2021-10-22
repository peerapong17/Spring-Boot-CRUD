package com.spring.springbootthymeleafcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.springbootthymeleafcrud.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
