package com.mistystrickland.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistystrickland.dojosandninjas.models.Ninja;
import com.mistystrickland.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// Create Ninja
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	// Get All Ninjas
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	// Find By dojo_id ?
	public Ninja getDojo(Long dojo_id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(dojo_id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
}
