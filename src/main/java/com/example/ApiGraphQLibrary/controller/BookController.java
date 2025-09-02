package com.example.ApiGraphQLibrary.controller;

import com.example.ApiGraphQLibrary.entity.Book;
import com.example.ApiGraphQLibrary.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> obtenerTodosLosLibros() {
        return bookService.findAll();
    }

    @MutationMapping
    public Book createBook(@Argument Book book) {
        return bookService.save(book);
    }
}
