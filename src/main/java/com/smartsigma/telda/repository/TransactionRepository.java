package com.smartsigma.telda.repository;

import com.smartsigma.telda.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
