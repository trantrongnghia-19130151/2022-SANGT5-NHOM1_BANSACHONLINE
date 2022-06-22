package com.bansach.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import com.bansach.service.BookStoreService;



@Controller
public class MainController {


	@Autowired
	private BookStoreService bookService;

	@GetMapping(value = { "/", "/index" })
	public String homePage(Model model) {
		model.addAttribute("listBook", bookService.pagination(0));
		return "index";
	}

	@GetMapping("/singleProduct/{id}")
	public String getSingleProduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("book", bookService.findBookById(id));
		return "singleProduct";
	}
	@GetMapping("/search")
	public String getSingleProduct(Model model) {
		model.addAttribute(model);
		return "search";
	}

}
