package com.mistystrickland.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mistystrickland.savetravels.models.Expense;
import com.mistystrickland.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/expenses")
	public String dashboard(@ModelAttribute("charge") Expense charge, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String processNewExpense(@Valid @ModelAttribute("charge") Expense charge, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// render the index.jsp which includes the form + allExpenses
			model.addAttribute("expenses", expenseService.allExpenses());
			return "index.jsp";
		} else {
			expenseService.saveExpense(charge);
			return "redirect:/expenses";
		}
	}
}
