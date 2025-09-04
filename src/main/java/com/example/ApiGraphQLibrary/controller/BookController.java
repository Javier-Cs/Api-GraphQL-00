package com.example.ApiGraphQLibrary.controller;

import com.example.ApiGraphQLibrary.dto.BookPost;
import com.example.ApiGraphQLibrary.dto.BookPut;
import com.example.ApiGraphQLibrary.entity.Author;
import com.example.ApiGraphQLibrary.entity.Book;
import com.example.ApiGraphQLibrary.service.AuthorService;
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
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }



    @QueryMapping
    public List<Book> listaLibros() {
        return bookService.findAll();
    }

    @QueryMapping
    public Book listarLibroById(@Argument int id) {
        return bookService.findById(id);
    }

    @MutationMapping
    public Book createBook(@Argument BookPost bookPost) {
        return bookService.save(bookPost);
    }

    @MutationMapping
    public void deleteBook (@Argument int id) {
        bookService.deleteById(id);
    }

    @MutationMapping
    public Book updateBook(@Argument int id, @Argument BookPut bookPut) {
        return bookService.updateById(id, bookPut);
    }
}
