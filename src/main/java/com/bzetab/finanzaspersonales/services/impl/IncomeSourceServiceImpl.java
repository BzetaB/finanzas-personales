package com.bzetab.finanzaspersonales.services.impl;

import com.bzetab.finanzaspersonales.models.entities.IncomeSource;
import com.bzetab.finanzaspersonales.repositories.IncomeSourceRepository;
import com.bzetab.finanzaspersonales.services.IncomeSourceService;
import org.springframework.stereotype.Service;

@Service
public class IncomeSourceServiceImpl implements IncomeSourceService {

    private final IncomeSourceRepository incomeSourceRepository;

    public IncomeSourceServiceImpl(IncomeSourceRepository incomeSourceRepository) {
        this.incomeSourceRepository = incomeSourceRepository;
    }

    @Override
    public IncomeSource createIncomeSource(IncomeSource incomeSource) {
        return incomeSourceRepository.save(incomeSource);
    }
}
