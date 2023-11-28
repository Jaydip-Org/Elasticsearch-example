package com.example.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

}
