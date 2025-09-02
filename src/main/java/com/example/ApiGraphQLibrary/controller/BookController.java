package com.example.ApiGraphQLibrary.controller;

import com.example.ApiGraphQLibrary.dto.BookPost;
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
    public List<Book> obtenerTodosLosLibros() {
        return bookService.findAll();
    }

    @MutationMapping
    public Book createBook(@Argument BookPost bookPost) {
        Author author = authorService.findById(bookPost.id_autor());
        Book bookNew = new  Book();
        bookNew.setTitle(bookPost.title());
        bookNew.setYearPublic(bookPost.yearPublic());
        bookNew.setEditorial(bookPost.editorial());
        bookNew.setCode(bookPost.code());
        bookNew.setEstado(bookPost.estado());
        bookNew.setNumePage(bookPost.numePage());
        bookNew.setAuthor(author);
        return bookService.save(bookNew);
    }
}
