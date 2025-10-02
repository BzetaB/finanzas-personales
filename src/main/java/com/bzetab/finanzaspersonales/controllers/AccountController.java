package com.bzetab.finanzaspersonales.controllers;

import com.bzetab.finanzaspersonales.models.dto.AccountDto;
import com.bzetab.finanzaspersonales.utils.exceptions.model.SuccessResponse;
import com.bzetab.finanzaspersonales.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<SuccessResponse> createAccount(@Valid @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(
                SuccessResponse.builder()
                        .message("Account created successfully")
                        .status(HttpStatus.CREATED.value())
                        .data(accountService.createAccount(accountDto))
                        .build());
    }
}
