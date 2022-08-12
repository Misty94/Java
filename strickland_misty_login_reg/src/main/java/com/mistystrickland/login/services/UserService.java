package com.mistystrickland.login.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mistystrickland.login.models.LoginUser;
import com.mistystrickland.login.models.User;
import com.mistystrickland.login.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	// Register a New User
	public User register(User newUser, BindingResult result) {
		// Check to see if their email is already in the database
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail()); // Anytime you're finding 1 thing, the datatype is Optional
		// If the email is already in the database, reject
		if (optionalUser.isPresent()) { 
			result.rejectValue("email", "unique", "This email is already in use!");
		}
		// If the password doesn't match the confirm password, reject
		if (!newUser.getPassword().equals(newUser.getConfirm())) { 
			result.rejectValue("confirm", "match", "The passwords do not match!");
		}
		// If it has errors, leave the function
		if (result.hasErrors()) {
			return null;
		}
		// If no errors, hash the password
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		// Set the hashed password to the user
		newUser.setPassword(hashed);
		// And save User in the database
		return userRepo.save(newUser);
	}
	
	// Login an Existing User
	public User login(LoginUser newLoginObject, BindingResult result) {
		// Check to see if their email is already in the database
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
		// If the email is NOT in the database, reject
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "Email not found!");
			return null; // Leave the function
		}
		// Now the potentialUser is confirmed to be an existing User
		User user = potentialUser.get();
		// If the password typed in the form does not match the password from the database, reject
		if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			result.rejectValue("password", "match", "Invaid password!");
		}
		// If there are errors, leave the function
		if (result.hasErrors()) {
			return null;
		}
		// Otherwise, return the User object
		return user;
	}
	
	// Anytime you find/get 1 - it is optional!
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
}
