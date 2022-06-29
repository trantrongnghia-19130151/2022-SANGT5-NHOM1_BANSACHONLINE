package com.bansach.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bansach.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("SELECT b FROM Book b WHERE b.price BETWEEN  ?1 AND ?2")
	List<Book> findByPrice(double price1, double price2);

	// 9. Tạo câu lệnh SQL
	@Query("SELECT b FROM Book b WHERE b.name like %?1%")
	List<Book> autoComplete(String name);

	@Query("SELECT b FROM Book b WHERE b.id = ?1")
	Book findBookById(int id);

	@Query("SELECT b FROM Book b WHERE " + "CONCAT(b.id, ' ', b.name, ' ', b.category, ' ', b.price)" + " LIKE %?1%")
	public Page<Book> findAll(String keyword, Pageable pageable);
}
