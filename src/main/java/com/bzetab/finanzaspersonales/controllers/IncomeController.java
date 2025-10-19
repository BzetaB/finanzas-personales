package com.bzetab.finanzaspersonales.controllers;

import com.bzetab.finanzaspersonales.models.dto.IncomeDto;
import com.bzetab.finanzaspersonales.services.IncomeService;
import com.bzetab.finanzaspersonales.utils.exceptions.model.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/income")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService){
        this.incomeService = incomeService;
    }

    @PostMapping("/create")
    public ResponseEntity<SuccessResponse> addIncome(@RequestBody IncomeDto incomeDto) {
        return ResponseEntity.ok(
                SuccessResponse.builder()
                        .message("Income created successfully")
                        .status(HttpStatus.CREATED.value())
                        .data(incomeService.addIncome(incomeDto))
                        .build());
    }
}
