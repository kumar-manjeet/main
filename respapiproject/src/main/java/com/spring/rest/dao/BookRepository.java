package com.spring.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.rest.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);

}
