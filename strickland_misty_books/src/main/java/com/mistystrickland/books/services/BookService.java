package com.mistystrickland.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mistystrickland.books.models.Book;
import com.mistystrickland.books.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	// Find All Books
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	// Create a Book
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	// Finds One Book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	// Update One
	public Book updateBook (Long id, String title, String description, String language, Integer numberOfPages) {
		Book editBook = this.findBook(id);
		editBook.setTitle(title);
		editBook.setDescription(description);
		editBook.setLanguage(language);
		editBook.setNumberOfPages(numberOfPages);
		return bookRepo.save(editBook);
	}
	
	// Delete One
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
