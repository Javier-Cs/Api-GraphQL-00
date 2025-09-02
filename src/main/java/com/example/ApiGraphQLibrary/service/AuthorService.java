package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.entity.Author;
import com.example.ApiGraphQLibrary.repository.AuthorRepo;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements CrudService<Author, Integer>{

    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    @Override
    public Author findById(Integer id) {
        return authorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
    }

    @Override
    public Author save(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public void deleteById(Integer id) {
        authorRepo.deleteById(id);
    }

    @Override
    public Author updateById(Integer id, Author authorDetails) {
        Author authorUp = authorRepo.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Author with id " + id + " not found"));
        authorUp.setName(authorDetails.getName());
        authorUp.setLastName(authorDetails.getLastName());
        return authorRepo.save(authorUp);
    }
}
