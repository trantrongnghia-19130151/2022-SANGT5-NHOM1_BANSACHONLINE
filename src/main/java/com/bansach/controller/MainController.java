package com.bansach.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bansach.entities.Book;
import com.bansach.entities.OrderDetail;
import com.bansach.entities.ShoppingCart;
import com.bansach.entities.ShoppingCartItem;
import com.bansach.service.BookStoreService;
import com.bansach.service.OrderDetailService;


@Controller
public class MainController {

	@Autowired
	private BookStoreService bookService;


	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = { "/", "/index" })
	public String homePage(Model model) {
		model.addAttribute("listBook", bookService.pagination(0));
		return "index";
	}
	@RequestMapping(value = "/shop-grid")
	public String shop(Model model) {
		model.addAttribute("listBook", bookService.pagination(0));
		return "shop-grid";
	}

	@GetMapping(value = "/cart")
	public String cart() {
		return "cart";
	}

	@GetMapping("/singleProduct/{id}")
	public String getSingleProduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("book", bookService.findBookById(id));
		return "singleProduct";
	}

	/*
	 * Shopping cart
	 */
	@GetMapping("/addCart/{id}")
	public String addCart(HttpSession session, @PathVariable int id, Model model) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		if (id != 0) {
			Book p = bookService.findBookById(id);
			cart.add(id, p);
			System.out.println("them san pham vao gio hang thanh cong");
		}
		model.addAttribute("numberOfItems", cart.getNumberOfItems());
		model.addAttribute("total", cart.getTotal());
		model.addAttribute("books", cart.getItems());
		return "cart";
	}

	@GetMapping("/removeCart/{id}")
	public String removeCart(HttpSession session, @PathVariable("id") int id, Model model) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		if (id != 0) {
			cart.remove(id);
		}
		model.addAttribute("numberOfItems", cart.getNumberOfItems());
		model.addAttribute("total", cart.getTotal());
		model.addAttribute("books", cart.getItems());
		return "cart";
	}

	@GetMapping("/getCart")
	public String getCart(HttpSession session, Model model) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		model.addAttribute("numberOfItems", cart.getNumberOfItems());
		model.addAttribute("total", cart.getTotal());
		model.addAttribute("books", cart.getItems());
		return "cart";
	}


	@GetMapping("/checkout")
	public String checkout2(HttpSession session, Model model) {
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		model.addAttribute("numberOfItems", cart.getNumberOfItems());
		model.addAttribute("total", cart.getTotal());
		model.addAttribute("books", cart.getItems());
		return "checkout";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/403")
	public String notfoundpage() {
		return "403";
	}


}
