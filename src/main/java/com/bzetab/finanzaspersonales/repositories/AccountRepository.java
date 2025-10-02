package com.bzetab.finanzaspersonales.repositories;

import com.bzetab.finanzaspersonales.models.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
