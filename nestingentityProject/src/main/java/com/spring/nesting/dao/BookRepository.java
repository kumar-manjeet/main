package com.spring.nesting.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.nesting.entities.DemoBook;

public interface BookRepository extends CrudRepository<DemoBook, Integer>{
	
	public DemoBook findById(int id);

}
