package com.mistystrickland.projectmanager.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {

	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!") // This does not require the email to be there!
	private String email;
	
	@Size(min=8, message="Your password must be at least 8 characters long!")
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
