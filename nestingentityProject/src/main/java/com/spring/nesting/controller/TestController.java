package com.spring.nesting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.nesting.entities.DemoBook;
import com.spring.nesting.services.BookService;


@Controller
public class TestController {
	
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/books")
	public ResponseEntity<List<DemoBook>> getBooks() {

		List<DemoBook> allBooks = bookservice.getAllBook();
		if(allBooks.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(allBooks);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<DemoBook> getBook(@PathVariable("id") int id) {
		 DemoBook bookById = bookservice.getBookById(id);
		 if(bookById==null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(bookById));
		
	}
	
	@PostMapping("/books")
	public ResponseEntity<DemoBook> addBook(@RequestBody DemoBook book) {
		try {
			DemoBook addBook =null;
			addBook = bookservice.addBook(book);
			return ResponseEntity.of(Optional.of(addBook));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			this.bookservice.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	@PutMapping("books/{bookId}")
	public ResponseEntity<DemoBook> updateBook(@RequestBody DemoBook book, @PathVariable("bookId") int bookId) {
		try {
			this.bookservice.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
