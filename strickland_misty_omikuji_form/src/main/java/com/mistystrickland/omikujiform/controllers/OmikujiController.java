package com.mistystrickland.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {

	@GetMapping("/omikuji")
	public String omikujiForm() {
		return "form.jsp";
	}
	
	@PostMapping("/process")
	public String processForm(
			@RequestParam("num") String num,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,
			@RequestParam("thing") String thing,
			@RequestParam("comment") String comment,
			HttpSession session
			) {
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("comment", comment);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String showFortune() {
		return "fortune.jsp";
	}
}
