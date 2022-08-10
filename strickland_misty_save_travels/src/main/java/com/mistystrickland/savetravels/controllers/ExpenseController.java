package com.mistystrickland.savetravels.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.mistystrickland.savetravels.models.Expense;
import com.mistystrickland.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;

	// Render All Expense & New Expense Form
	@GetMapping("/expenses")
	public String dashboard(@ModelAttribute("charge") Expense charge, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	// Process New Expense
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
	
	// Render Edit Form
	@GetMapping("/expenses/edit/{id}")
	public String renderEdit(@PathVariable("id") Long id, Model model) {
		Expense getExpense = expenseService.oneExpense(id);
		model.addAttribute("charge", getExpense);
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("charge") Expense charge, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(charge);
			return "redirect:/expenses";
		}
	}
}
