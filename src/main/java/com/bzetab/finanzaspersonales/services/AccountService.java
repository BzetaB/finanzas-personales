package com.bzetab.finanzaspersonales.services;

import com.bzetab.finanzaspersonales.models.dto.AccountDto;
import com.bzetab.finanzaspersonales.models.entities.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    Account findByName(String name);
}
