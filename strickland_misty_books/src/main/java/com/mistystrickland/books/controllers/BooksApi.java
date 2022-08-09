package com.mistystrickland.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mistystrickland.books.models.Book;
import com.mistystrickland.books.services.BookService;

@RestController
@RequestMapping("/api")
public class BooksApi {

	private final BookService bookService;
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	// Get All
	@GetMapping("/books")
	public List<Book> index(){
		return bookService.allBooks();
	}
	
	// Create
	@PostMapping("/books")
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer 	numOfPages) {
		Book newBook = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(newBook);
	}
	
	// Get One
	@GetMapping("/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book oneBook = bookService.findBook(id);
		return oneBook;
		// OR return bookService.findBook(id);
	}
	
	// Update/Edit One -> Find One and Save/Create
	@PutMapping("/books/{id}")
	public Book update(
			@PathVariable("id") Long id, // id from the path variable
			@RequestParam(value="title") String title, // info from RequestParam / body
			@RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang,
			@RequestParam(value="pages") Integer numOfPages) {
		Book bookUpdated = bookService.updateBook(id, title, desc, lang, numOfPages);
		return bookUpdated;
		// OR return bookService.updateBook(id, title, desc, lang, numOfPages);
	}
	
	// Delete One
	@DeleteMapping("/books/{id}")
	public void removeBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
}
