package com.welisson.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welisson.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
