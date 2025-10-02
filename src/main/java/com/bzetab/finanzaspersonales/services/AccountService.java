package com.bzetab.finanzaspersonales.services;

import com.bzetab.finanzaspersonales.models.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
}
