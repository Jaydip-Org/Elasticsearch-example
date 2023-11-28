package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public ResponseEntity<Void> saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/elastic")
	public ResponseEntity<List<Book>> getAllBooksElastic() {
		List<Book> books = bookService.getAllBooksElastic();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@GetMapping(value = "/jpa")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

}
