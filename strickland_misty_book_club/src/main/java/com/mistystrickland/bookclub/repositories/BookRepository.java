package com.mistystrickland.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mistystrickland.bookclub.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findAll();
	
	
	
	
	
	
	
	
	
	// ideas for Book Broker that did not work
	// The user_id and the borrower_id is the same id because they are the same person.
//	List<Book> findByBorrowerId();

//	List<Book> findByUserId(Long user_id);

//	List<Book> findByBorrowedBooksNotIn(List<Book> borrowedBooks);

}
