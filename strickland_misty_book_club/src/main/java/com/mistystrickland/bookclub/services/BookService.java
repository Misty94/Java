package com.mistystrickland.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistystrickland.bookclub.models.Book;
import com.mistystrickland.bookclub.models.User;
import com.mistystrickland.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private UserService userService;
	
	
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
	
	// Book Broker
	
	public void createBorrower(Long bookId, Long userId) {
		User user = userService.findById(userId);
		Book book = this.oneBook(bookId);
		book.setBorrower(user);
		bookRepo.save(book);
	}
	
	public void returnBook(Long bookId) {
		Book book = this.oneBook(bookId);
		book.setBorrower(null);
		bookRepo.save(book);
	}
	
//	public List<Book> availbleBooks(User user){
//		return bookRepo.findByBorrowerId(null);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	// Set a User to borrow a Book (making user the borrower)
//	public void createBorrower(Book book, User user) {
		// book.setBorrower(user); // set the borrower to be the user
		// bookRepo.save(book); // and save the book to the borrower 
//	}
	
	// Remove a User as a Borrower
//	public void returnBook(Book book) {
		// book.setBorrower(null); // set the borrower to be null (removing the user from that book)
		// bookRepo.save(book); // save the book that now has no borrower
//	}
	
	// Get All Books that are Available
//	public List<Book> availableBooks(){
//		return bookRepo.findByBorrowedBooksNotIn(null);
//	}

	// Find All Books that a specific user borrowed ====== Not Right
//	public List<Book> userBorrowed(User user_id){
//		return bookRepo.findByUserId(user_id);
//	}
}
