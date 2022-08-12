package com.mistystrickland.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mistystrickland.dojosandninjas.models.Dojo;
import com.mistystrickland.dojosandninjas.models.Ninja;
import com.mistystrickland.dojosandninjas.services.DojoService;
import com.mistystrickland.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {

	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	// Render New Dojo Form
	@GetMapping("/dojos/new")
	public String dojoForm(@ModelAttribute("DOJO") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	// Process New Dojo Form
	@PostMapping("/dojos/new")
	public String processDojo(@Valid @ModelAttribute("DOJO") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.saveDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	// Render New Ninja Form
	@GetMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		// I need this for the dropdown in jsp
		List<Dojo> dojoList = dojoService.allDojos();
		model.addAttribute("dojoList", dojoList);
		return "newNinja.jsp";
	}
	
	// Process New Ninja Form
	@PostMapping("/ninjas/new")
	public String processNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// if the user does have errors, you need to add this to render the form correctly again
			List<Dojo> dojoList = dojoService.allDojos();
			model.addAttribute("dojoList", dojoList);
			// otherwise, the dropdown will be empty
			return "newNinja.jsp";
		} else {
			ninjaService.saveNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
	
	// Get One Dojo
	@GetMapping("/dojos/{id}")
	public String dojoNinjas(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.oneDojo(id));
		// model.addAttribute("ninjaList", ninjaService.allNinjas());
		// model.addAttribute("ninja", ninjaService.getDojo(dojo_id));
		return "dojoNinja.jsp";
	}
}
