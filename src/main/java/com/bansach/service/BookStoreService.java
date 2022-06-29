package com.bansach.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bansach.entities.Book;
import com.bansach.repository.BookRepository;
@Service
public class BookStoreService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> listBook(){
		return bookRepository.findAll();
	}
	
	public Optional<Book> getBookById(int id){
		return bookRepository.findById(id);
	}
	
	public Book findBookById(int id) {
		return bookRepository.findBookById(id);
	}
	public Page<Book> pagination(int pageNumber){
		PageRequest pageable = PageRequest.of(pageNumber, 12);
		return bookRepository.findAll(pageable);
	}
	public List<Book> filterPrice(double price1, double price2){
		return bookRepository.findByPrice(price1, price2);
	}
	// 8. Gọi phương thức autoComplete(name) đến BookRepository
	public List<Book> autoComplete(String name){
		return bookRepository.autoComplete(name);
	}
}
