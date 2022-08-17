package com.mistystrickland.projectmanager.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mistystrickland.projectmanager.models.LoginUser;
import com.mistystrickland.projectmanager.models.User;
import com.mistystrickland.projectmanager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "exists", "This email is already in use!");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "different", "The passwords do not match!");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		
		Optional<User> optionalUser = userRepo.findByEmail(newLoginObject.getEmail());
		if (!optionalUser.isPresent()) {
			result.rejectValue("email", "absent", "Email not found!");
			return null;
		}
		User user = optionalUser.get();
		if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			result.rejectValue("password", "different", "Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
}
