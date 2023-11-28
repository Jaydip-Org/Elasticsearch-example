package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.repository.elasticsearch.BookElasticsearchRepository;
import com.example.repository.jpa.BookJpaRepository;

@Service
public class BookService {

	@Autowired
	private BookJpaRepository jpaRepository;

	@Autowired
	private BookElasticsearchRepository elasticsearchRepository;

	public List<Book> getAllBooks() {
		return jpaRepository.findAll();
	}

	public List<Book> getAllBooksElastic() {
		List<Book> books = new ArrayList<>();
		elasticsearchRepository.findAll().forEach(books::add);
		return books;
	}

	public void saveBook(Book book) {
		jpaRepository.save(book);
		elasticsearchRepository.save(book);
	}

}
