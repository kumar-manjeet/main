package com.spring.nestingentity.entity;

import jakarta.persistence.Entity;

@Entity
public class Books {
	
	public int id;
	
	public String title;
	
	public Author author;

}
