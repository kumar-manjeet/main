package com.spring.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.rest.dao.BookRepository;
import com.spring.rest.entity.Book;

@Component
public class BookService {
	

	
	private static List<Book> list = new ArrayList<>();
	static {
		list.add(new Book(12, "java book", "xyz"));
		list.add(new Book(26, "python book", "stu"));
		list.add(new Book(36, "c#", "sfu"));
	}
	
	public List<Book> getAllBooks(){
		return list;
	}
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e->e.getId() == id).findFirst().get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	public Book addBook(Book book) {
		 list.add(book);
		return book;
	}
	public void deleteBook(int b_Id) {
		list.stream().filter(book->book.getId()!=b_Id).collect(Collectors.toList());
		System.out.println("deleted............");
		
	}
	public void updateBook(Book book, int bookId) {
		list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
