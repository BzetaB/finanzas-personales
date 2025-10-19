package com.bzetab.finanzaspersonales.repositories;

import com.bzetab.finanzaspersonales.models.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {
}
