package com.bansach.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bansach.entities.*;
import com.bansach.service.BookStoreService;

@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private BookStoreService bookService; 
		

	
	@GetMapping("/listBook")
	public List<Book> homeService(){
		return bookService.listBook();
	}
	
	@GetMapping("/getBook/{id}")
	public Optional<Book> getById(@PathVariable("id") int id){
		return bookService.getBookById(id);
	}
	
	@GetMapping("/pagination")
	public Page<Book> pagination(int pageNumber){
		return bookService.pagination(pageNumber);
	}
	
	@GetMapping(value= {"/addCart/updateCart","/removeCart/updateCart","/updateCart","/cart/updateCart"})
	public ShoppingCart updateCart(HttpSession session,int id, int newQuantity) {
		System.out.println("Id "+id+" newQuantity "+newQuantity);
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		cart.update(id, newQuantity);
		return cart;
	}
	
}
