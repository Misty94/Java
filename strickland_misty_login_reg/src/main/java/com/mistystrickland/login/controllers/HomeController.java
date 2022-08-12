package com.mistystrickland.login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mistystrickland.login.models.LoginUser;
import com.mistystrickland.login.models.User;
import com.mistystrickland.login.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String displayLogin(Model model) {
		model.addAttribute("newUser", new User()); // This will create an empty User in the jsp model
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	// Process the Registration
	@PostMapping("/register")
	public String processRegistration(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {
		
		userService.register(newUser, result);
		// If there are errors
		if (result.hasErrors()) {
			// re-render the page & since the newUser is already there, it becomes the LoginUser model
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		// if there are no errors, store the userId in session (giving us access to all of user's info)
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
	}
	
	//Process the Login
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, 
			Model model, HttpSession session) {
		
		User user = userService.login(newLogin, result);
		
		if (result.hasErrors()) {
			// since LoginUser is already there, it becomes the User model
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		// if the user is not in session (has not logged in), redirect
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		// userId comes from session & need to cast as datatype Long
		Long userId = (Long) session.getAttribute("userId");
		// Send "currUser" to jsp
		model.addAttribute("currUser", userService.findById(userId));
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// this will clear the session
		session.invalidate();
		return "redirect:/";
	}
}
