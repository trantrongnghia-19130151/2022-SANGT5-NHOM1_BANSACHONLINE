package com.bansach.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.bansach.entities.*;
import com.bansach.service.BookStoreService;



@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private BookStoreService bookService; 
	
	@GetMapping("/autoComplete")
	public List<Book> autoComplete( String name){
		System.out.println("Name : "+name);
		return bookService.autoComplete(name);
	}
	
}
