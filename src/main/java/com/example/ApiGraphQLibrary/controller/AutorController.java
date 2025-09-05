package com.example.ApiGraphQLibrary.controller;

import com.example.ApiGraphQLibrary.dto.AuthorPost;
import com.example.ApiGraphQLibrary.dto.AuthorPut;
import com.example.ApiGraphQLibrary.entity.Author;
import com.example.ApiGraphQLibrary.service.AuthorService;
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
    public List<Author> listarAutores() {
        return authorService.findAll();
    }

    @QueryMapping
    public Author listarAutorById(@Argument int id) {
        return authorService.findById(id);
    }

    @MutationMapping
    public Author createAuthor(@Argument AuthorPost authorPost) {
        return authorService.save(authorPost);
    }

    @MutationMapping
    public void deleteAuthor(@Argument int id){
        authorService.deleteById(id);
    }

    @MutationMapping
    public Author updateAuthor(@Argument int id, @Argument AuthorPut authorPut) {
        return authorService.updateById(id, authorPut);
    }

}
