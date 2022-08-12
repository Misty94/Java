package com.mistystrickland.login.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mistystrickland.login.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	// To Search for the Email
	Optional<User> findByEmail(String email);
}
