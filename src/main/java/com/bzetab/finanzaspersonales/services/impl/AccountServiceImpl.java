package com.bzetab.finanzaspersonales.services.impl;

import com.bzetab.finanzaspersonales.models.dto.AccountDto;
import com.bzetab.finanzaspersonales.models.entities.Account;
import com.bzetab.finanzaspersonales.models.mappers.AccountMapper;
import com.bzetab.finanzaspersonales.repositories.AccountRepository;
import com.bzetab.finanzaspersonales.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountMapper.toAccountEntity(accountDto);
        Account saved = accountRepository.save(account);
        return accountMapper.toAccountDto(saved);
    }
}
