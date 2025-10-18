package com.bzetab.finanzaspersonales.services;

import com.bzetab.finanzaspersonales.models.entities.IncomeSource;

public interface IncomeSourceService {
    IncomeSource createIncomeSource(IncomeSource incomeSource);
    IncomeSource findByName(String name);
}
