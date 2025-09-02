package com.example.ApiGraphQLibrary.controller;

import com.example.ApiGraphQLibrary.dto.AuthorGet;
import com.example.ApiGraphQLibrary.entity.Author;
import com.example.ApiGraphQLibrary.service.AuthorService;
import jakarta.persistence.Column;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AutorController {
    private final AuthorService authorService;

    public AutorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @QueryMapping
    public List<Author> ListaAuthor() {
        return authorService.findAll();
    }


    @MutationMapping
    public Author createAuthor(@Argument AuthorGet authorGet) {
        Author authorNew = new  Author();
        authorNew.setName(authorGet.name());
        authorNew.setLastName(authorGet.lastName());
        return authorService.save(authorNew);
    }

}
