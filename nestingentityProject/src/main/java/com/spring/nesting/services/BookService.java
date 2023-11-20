package com.spring.nesting.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.nesting.dao.BookRepository;
import com.spring.nesting.entities.DemoBook;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public List<DemoBook> getAllBook(){
		
		List<DemoBook> list = (List<DemoBook>)this.bookRepository.findAll();
		return list;
	}
	
	public DemoBook getBookById(int id) {
		DemoBook demoBook = null;
		try {
			demoBook = this.bookRepository.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return demoBook;
	}
	
	public DemoBook addBook(DemoBook demoBook) {
		DemoBook result = bookRepository.save(demoBook);
		return result;
	}
	
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
	
	public void updateBook(DemoBook demoBook, int bookId) {
		bookRepository.save(demoBook);
		demoBook.setId(bookId);
		bookRepository.save(demoBook);
	}
}
