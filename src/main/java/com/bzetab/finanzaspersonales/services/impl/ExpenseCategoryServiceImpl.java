package com.bzetab.finanzaspersonales.services.impl;

import com.bzetab.finanzaspersonales.models.entities.ExpenseCategory;
import com.bzetab.finanzaspersonales.repositories.ExpenseCategoryRepository;
import com.bzetab.finanzaspersonales.services.ExpenseCategoryService;
import org.springframework.stereotype.Service;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseCategoryServiceImpl(ExpenseCategoryRepository expenseCategoryRepository){
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    @Override
    public ExpenseCategory createExpenseCategory(ExpenseCategory expenseCategory) {
        return expenseCategoryRepository.save(expenseCategory);
    }
}
