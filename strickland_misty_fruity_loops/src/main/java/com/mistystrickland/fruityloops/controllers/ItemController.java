package com.mistystrickland.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mistystrickland.fruityloops.models.Item;

@Controller
public class ItemController {

	@RequestMapping("/")
	public String index(Model model) {
		
		ArrayList<Item> fruits = new ArrayList<Item>();
		fruits.add(new Item("Kiwi", 1.5));
		fruits.add(new Item("Mango", 2.00));
		fruits.add(new Item("Goji Berries", 4.00));
		fruits.add(new Item("Guava", 0.75));
		fruits.add(new Item("Banana", 1.00));
		fruits.add(new Item("Strawberries", 1.25));
		
		model.addAttribute("fruits", fruits);
		
		return "index.jsp";
	}
}
