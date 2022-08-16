package com.mistystrickland.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mistystrickland.bookclub.models.Book;
import com.mistystrickland.bookclub.models.LoginUser;
import com.mistystrickland.bookclub.models.User;
import com.mistystrickland.bookclub.services.BookService;
import com.mistystrickland.bookclub.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	// -----------------------LOGIN-------------------------------------
	
	@GetMapping("/")
	public String loginPage(Model model) {
		// Creates an empty User object in the jsp to capture form input
		model.addAttribute("newUser", new User());
		// Creates an empty LoginUser object in the jsp to capture form input
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	@PostMapping("/register")
	public String processRegistration(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, 
			Model model, HttpSession session) {
		
		userService.register(newUser, result);
		if (result.hasErrors()) {
			// re-render the page & since the newUser is already there, send in empty LoginUser object
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("userId", newUser.getId());
		return "redirect:/books";
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, 
			Model model, HttpSession session) {
		
		User user = userService.login(newLogin, result);
		if (result.hasErrors()) {
			// Since newLogin is already there, send in empty User object to re-render the page
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/books";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// -----------------------DASHBOARD-------------------------------------
	
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		// Cast userId that's in session as Long datatype 
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("currUser", userService.findById(userId));
		
		List<Book> bookList = bookService.allBooks();
		model.addAttribute("bookList", bookList);
		
		return "dashboard.jsp";
	}
	
	// -----------------------CREATE A BOOK-------------------------------------
	
	@GetMapping("/books/new")
	public String addBookPage(HttpSession session, @ModelAttribute("book") Book book) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		
		return "newBook.jsp";
	}
	
	@PostMapping("/books/new")
	public String processBook(@Valid @ModelAttribute("book") Book book, BindingResult result, 
			Model model, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "newBook.jsp";
		} else {
			bookService.saveBook(book);
			return "redirect:/books";
		}
	}
	
	// -----------------------FIND ONE BOOK-------------------------------------
	
	@GetMapping("/books/{id}")
	public String bookDetails(@PathVariable("id") Long id, HttpSession session, Model model) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		model.addAttribute("book", bookService.oneBook(id));
		return "bookDetails.jsp";
	}
	
	// -----------------------EDIT ONE BOOK-------------------------------------
	
	@GetMapping("/books/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		// Ensure that ONLY the owner of the book can edit that book
		Book book = bookService.oneBook(id);
		if (book.getUser().getId() != (Long) session.getAttribute("userId")) {
			return "redirect:/books";
		}
		model.addAttribute("book", bookService.oneBook(id));
		return "editBook.jsp";
	}
	
	@PutMapping("/books/{id}/edit")
	public String processEdit(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, 
			BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			// model.addAttribute("book", bookService.oneBook(id));
//			System.out.println(result.getFieldErrors());
			return "editBook.jsp";
		} else {
			bookService.saveBook(book);
			return "redirect:/books";
		}
	}
	
	// -----------------------DELETE ONE BOOK-------------------------------------
	
	@DeleteMapping("/book/delete/{id}")
	public String processDelete(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, 
			BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		// Ensure that ONLY the owner of the book can delete that book ???? I don't think this is needed.
		Book usersBook = bookService.oneBook(id);
		if (usersBook.getUser().getId() != (Long) session.getAttribute("userId")) {
			return "redirect:/books";
		}
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	// -----------------------BOOK BROKER-------------------------------------
	
	@GetMapping("/bookmarket")
	public String bookMarketPage(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		// Cast userId that's in session as Long datatype 
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("currUser", userService.findById(userId));
		
		List<Book> bookList = bookService.allBooks();
		model.addAttribute("bookList", bookList);
		
		return "bookMarket.jsp";
	}
	
	// -----------------------BORROW BOOK-------------------------------------
	
	@PutMapping("/book/borrow/{id}")
	public String borrowBook(@PathVariable("id") Long bookId, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		bookService.createBorrower(bookId, userId);
		return "redirect:/bookmarket";
	}
	
	// -----------------------RETURN BOOK-------------------------------------
	
	@PutMapping("/book/return/{id}")
	public String returnBook(@PathVariable("id") Long bookId, HttpSession session) {
		if (session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		bookService.returnBook(bookId);
		return "redirect:/bookmarket";
	}
	
}
