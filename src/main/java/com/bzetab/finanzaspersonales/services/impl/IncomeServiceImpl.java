package com.bzetab.finanzaspersonales.services.impl;

import com.bzetab.finanzaspersonales.models.dto.IncomeDto;
import com.bzetab.finanzaspersonales.models.entities.Account;
import com.bzetab.finanzaspersonales.models.entities.Income;
import com.bzetab.finanzaspersonales.models.entities.IncomeSource;
import com.bzetab.finanzaspersonales.models.mappers.IncomeMapper;
import com.bzetab.finanzaspersonales.repositories.IncomeRepository;
import com.bzetab.finanzaspersonales.services.AccountService;
import com.bzetab.finanzaspersonales.services.IncomeService;
import com.bzetab.finanzaspersonales.services.IncomeSourceService;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final IncomeSourceService incomeSourceService;
    private final AccountService accountService;
    private final IncomeMapper incomeMapper;

    public IncomeServiceImpl (IncomeRepository incomeRepository,
                              IncomeSourceService incomeSourceService,
                              AccountService accountService,
                              IncomeMapper incomeMapper){
        this.incomeRepository = incomeRepository;
        this.incomeSourceService = incomeSourceService;
        this.accountService = accountService;
        this.incomeMapper = incomeMapper;
    }

    @Override
    public IncomeDto addIncome(IncomeDto incomeDto) {
        Income income = incomeMapper.toIncomeEntity(incomeDto);
        Account account = accountService.findByName(incomeDto.getAccount());
        IncomeSource incomeSource = incomeSourceService.findByName(incomeDto.getIncomeSource());
        income.setAccount(account);
        income.setIncomeSource(incomeSource);
        Income saved = incomeRepository.save(income);
        return incomeMapper.toIncomeDto(saved);
    }
}
