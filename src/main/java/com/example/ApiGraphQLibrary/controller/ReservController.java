package com.example.ApiGraphQLibrary.controller;

import com.example.ApiGraphQLibrary.dto.ReservPost;
import com.example.ApiGraphQLibrary.dto.ReservPut;
import com.example.ApiGraphQLibrary.entity.Book;
import com.example.ApiGraphQLibrary.entity.Reserv;
import com.example.ApiGraphQLibrary.entity.User;
import com.example.ApiGraphQLibrary.service.BookService;
import com.example.ApiGraphQLibrary.service.ReservService;
import com.example.ApiGraphQLibrary.service.UserServiceImp;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ReservController {

    private final ReservService reservService;
    private final BookService bookService;
    private final UserServiceImp userService;

    public ReservController(ReservService reservService, BookService bookService, UserServiceImp userService) {
        this.reservService = reservService;
        this.bookService = bookService;
        this.userService = userService;
    }


    @QueryMapping
    public List<Reserv> listarReserv() {
        return reservService.findAll();
    }

    @QueryMapping
    public Reserv listarReservById(@Argument int id) {
        return reservService.findById(id);
    }

    @MutationMapping
    public Reserv createReserv(@Argument ReservPost reservPost){
        return reservService.save(reservPost);
    }

    @MutationMapping
    public Reserv updateReserv(@Argument int id, @Argument ReservPut reservPut){
        return  reservService.updateById(id,reservPut);
    }

    @MutationMapping
    public void deleteReserv(@Argument Integer id){
        reservService.deleteById(id);
    }
}
