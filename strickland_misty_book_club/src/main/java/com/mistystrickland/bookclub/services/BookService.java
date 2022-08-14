package com.mistystrickland.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistystrickland.bookclub.models.Book;
import com.mistystrickland.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	// Create a Book
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	// Get All Books
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	// Get One Book
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
			if (optionalBook.isPresent()) {
				return optionalBook.get();
			}
			else {
				return null;
			}
	}
	
	// Update a Book
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	// Delete a Book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
