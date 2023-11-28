package com.example.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Book;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

}
