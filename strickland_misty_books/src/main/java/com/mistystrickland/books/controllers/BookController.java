package com.mistystrickland.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mistystrickland.books.models.Book;
import com.mistystrickland.books.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Long bookId, Model model) {
		
		// Get the specific book from the service (database)
		Book oneBook = bookService.findBook(bookId);
		
		// Add the book to the jsp (done by Model model)
		model.addAttribute("oneBook", oneBook);
		
		return "show.jsp";
	}
}
