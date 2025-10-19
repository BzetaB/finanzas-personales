package com.bzetab.finanzaspersonales.models.mappers;

import com.bzetab.finanzaspersonales.models.dto.IncomeDto;
import com.bzetab.finanzaspersonales.models.entities.Income;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IncomeMapper {
    @Mapping(source = "incomeSource.name", target = "incomeSource")
    @Mapping(source = "account.name", target = "account")
    IncomeDto toIncomeDto(Income income);

    @Mapping(target = "account", ignore = true)
    @Mapping(target = "incomeSource", ignore = true)
    Income toIncomeEntity(IncomeDto incomeDto);
}
