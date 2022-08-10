package com.mistystrickland.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistystrickland.savetravels.models.Expense;
import com.mistystrickland.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;
	
	// Find All Expenses
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	// Create
	public Expense saveExpense(Expense charge) {
		return expenseRepo.save(charge);
	}
}
