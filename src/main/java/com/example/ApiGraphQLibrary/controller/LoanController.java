package com.example.ApiGraphQLibrary.controller;

import com.example.ApiGraphQLibrary.dto.LoanPost;
import com.example.ApiGraphQLibrary.dto.LoanPut;
import com.example.ApiGraphQLibrary.dto.ReservPost;
import com.example.ApiGraphQLibrary.dto.ReservPut;
import com.example.ApiGraphQLibrary.entity.Book;
import com.example.ApiGraphQLibrary.entity.Loan;
import com.example.ApiGraphQLibrary.entity.Reserv;
import com.example.ApiGraphQLibrary.entity.User;
import com.example.ApiGraphQLibrary.service.BookService;
import com.example.ApiGraphQLibrary.service.LoanService;
import com.example.ApiGraphQLibrary.service.UserServiceImp;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LoanController {

    private final LoanService loanService;
    private final BookService bookService;
    private final UserServiceImp  userServiceImp;

    public LoanController(LoanService loanService, BookService bookService, UserServiceImp userServiceImp) {
        this.loanService = loanService;
        this.bookService = bookService;
        this.userServiceImp = userServiceImp;
    }

    @QueryMapping
    public List<Loan> ListarLoan() {
        return loanService.findAll();
    }

    @QueryMapping
    public Loan listarLoanById(@Argument int id) {
        return loanService.findById(id);
    }

    @MutationMapping
    public Loan createLoan(@Argument LoanPost loanPost){
        return loanService.save(loanPost);
    }

    @MutationMapping
    public Loan updateLoan(@Argument int id, @Argument LoanPut loanPut){
        return  loanService.updateById(id,loanPut);
    }

    @MutationMapping
    public void deleteLoan(@Argument Integer id){
        loanService.deleteById(id);
    }
}
