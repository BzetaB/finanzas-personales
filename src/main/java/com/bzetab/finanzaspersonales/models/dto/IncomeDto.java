package com.bzetab.finanzaspersonales.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class IncomeDto {
    private LocalDate date;
    private String incomeSource;
    private String account;
    private Double amount;
    private String description;
}
