package com.mistystrickland.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistystrickland.savetravels.models.Expense;
import com.mistystrickland.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;
	
	// Get All Expenses
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	// Create
	public Expense saveExpense(Expense charge) {
		return expenseRepo.save(charge);
	}
	
	// Get One
	public Expense oneExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}

	// Update One
	public Expense updateExpense (Expense charge) {
		return expenseRepo.save(charge);
	}
}
