package com.bzetab.finanzaspersonales.controllers;

import com.bzetab.finanzaspersonales.models.dto.AccountDto;
import com.bzetab.finanzaspersonales.utils.exceptions.model.SuccessResponse;
import com.bzetab.finanzaspersonales.services.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
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

    @GetMapping
    public ResponseEntity<SuccessResponse> findAccountByName(@NotBlank(message = "Name is required") @RequestParam("name") String name ){
        return ResponseEntity.ok(
                SuccessResponse.builder()
                        .message("Account found successfully")
                        .status(HttpStatus.OK.value())
                        .data(accountService.findByName(name))
                        .build());
    }
}
