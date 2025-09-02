package com.example.ApiGraphQLibrary.repository;

import com.example.ApiGraphQLibrary.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {
}
