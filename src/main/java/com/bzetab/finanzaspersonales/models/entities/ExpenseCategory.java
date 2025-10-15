package com.bzetab.finanzaspersonales.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expenseCategory")
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is required")
    @Length(min = 3, message = "The field must have at least three characters")
    @Column(unique = true, nullable = false)
    private String name;
    private Boolean isFixed;
    private Double budget;
}
