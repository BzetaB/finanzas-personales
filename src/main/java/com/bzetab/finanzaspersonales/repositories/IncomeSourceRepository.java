package com.bzetab.finanzaspersonales.repositories;

import com.bzetab.finanzaspersonales.models.entities.IncomeSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeSourceRepository extends JpaRepository<IncomeSource, Integer> {
}
