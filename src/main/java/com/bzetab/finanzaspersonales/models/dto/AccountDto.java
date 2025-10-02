package com.bzetab.finanzaspersonales.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class AccountDto {
    @NotBlank(message = "Name is required")
    @Length(min = 3, message = "The field must have at least three characters")
    private String name;
    @NotBlank(message = "Name is required")
    @Length(min = 3, message = "The field must have at least three characters")
    private String bank;
    private Boolean isActive;
}
