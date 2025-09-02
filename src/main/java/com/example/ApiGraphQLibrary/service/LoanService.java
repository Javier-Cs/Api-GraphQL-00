package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.entity.Loan;
import com.example.ApiGraphQLibrary.repository.LoanRepo;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanService implements CrudService<Loan, Integer>{

    private final LoanRepo loanRepo;

    public LoanService(LoanRepo loanRepo) {
        this.loanRepo = loanRepo;
    }

    @Override
    public List<Loan> findAll() {
        return loanRepo.findAll();
    }

    @Override
    public Loan findById(Integer id) {
        return loanRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Not Found"));
    }

    @Override
    public Loan save(Loan loan) {
        return loanRepo.save(loan);
    }

    @Override
    public void deleteById(Integer id) {
        loanRepo.deleteById(id);
    }

    @Override
    public Loan updateById(Integer id, Loan loan) {
        Loan loanUp = loanRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        loanUp.setDateDevol(loan.getDateDevol());
        loanUp.setDatePrestamo(loan.getDatePrestamo());
        loanUp.setDateDevolucionReal(loan.getDateDevolucionReal());

        return loanRepo.save(loanUp);
    }
}
