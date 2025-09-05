package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.dto.LoanPost;
import com.example.ApiGraphQLibrary.dto.LoanPut;
import com.example.ApiGraphQLibrary.entity.Book;
import com.example.ApiGraphQLibrary.entity.Loan;
import com.example.ApiGraphQLibrary.entity.User;
import com.example.ApiGraphQLibrary.info.tools.Tools;
import com.example.ApiGraphQLibrary.repository.BookRepo;
import com.example.ApiGraphQLibrary.repository.LoanRepo;
import com.example.ApiGraphQLibrary.repository.UserRepo;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class LoanService implements CrudService<Loan, Integer>{

    private final LoanRepo loanRepo;
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public LoanService(LoanRepo loanRepo, BookRepo bookRepo, UserRepo userRepo) {
        this.loanRepo = loanRepo;
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
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
        throw new UnsupportedOperationException("Fuera de Uso");
    }

    @Override
    public void deleteById(Integer id) {
        loanRepo.deleteById(id);
    }

    @Override
    public Loan updateById(Integer id, Loan loan) {
        throw new UnsupportedOperationException("Fuera de Uso");
    }

    public Loan save(LoanPost loanPost) {
        Loan loanNew = new  Loan();

        loanNew.setDatePrestamo(Tools.converStr_Date(loanPost.datePrestamo()));
        loanNew.setDateDevol(Tools.converStr_Date(loanPost.dateDevol()));
        loanNew.setDateDevolucionReal(Tools.converStr_Date(loanPost.dateDevolucionReal()));
        loanNew.setBook(bookRepo.findById(loanPost.id_book()).orElseThrow(
                () -> new ResourceNotFoundException("Book Not Found")
        ));
        loanNew.setUser(userRepo.findById(loanPost.id_user()).orElseThrow(
                () -> new ResourceNotFoundException("User Not Found")
        ));

        return loanRepo.save(loanNew);
    }

    public Loan updateById(Integer id, LoanPut loanPut) {
        Loan loanUpdate = findById(id);
        if (loanPut.dateDevol() != null){
            loanUpdate.setDateDevol(Tools.converStr_Date(loanPut.dateDevol()));
        }
        if (loanPut.dateDevolucionReal() != null) {
            loanUpdate.setDateDevolucionReal(Tools.converStr_Date(loanPut.dateDevolucionReal()));
        }

        return loanRepo.save(loanUpdate);
    }

}
