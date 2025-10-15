package com.bzetab.finanzaspersonales.controllers;

import com.bzetab.finanzaspersonales.models.entities.ExpenseCategory;
import com.bzetab.finanzaspersonales.services.ExpenseCategoryService;
import com.bzetab.finanzaspersonales.utils.exceptions.model.SuccessResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/expense-category")
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService){
        this.expenseCategoryService = expenseCategoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<SuccessResponse>createExpenseCategory(@Valid @RequestBody ExpenseCategory expenseCategory) {
        return ResponseEntity.ok(SuccessResponse.builder()
                .message("Expense Category created successfully")
                .status(HttpStatus.CREATED.value())
                .data(expenseCategoryService.createExpenseCategory(expenseCategory))
                .build());
    }
}