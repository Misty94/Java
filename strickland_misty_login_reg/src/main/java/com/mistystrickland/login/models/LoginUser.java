package com.mistystrickland.login.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// This model is only for validating the input from the login form, so nothing will be sent to the database!
public class LoginUser {

	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, message="Password must be at least 8 characters long")
	private String password;
	
	// Constructors 
	
	public LoginUser () {}

	// Getters & Setters 
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
