package com.mistystrickland.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistystrickland.dojosandninjas.models.Dojo;
import com.mistystrickland.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo;
	
	// Get All Dojos
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	// Get One Dojo
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	// Create Dojo
	public Dojo saveDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
