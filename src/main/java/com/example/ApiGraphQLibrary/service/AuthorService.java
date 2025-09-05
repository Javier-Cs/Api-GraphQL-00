package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.dto.AuthorPost;
import com.example.ApiGraphQLibrary.dto.AuthorPut;
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
        throw new UnsupportedOperationException("Fuera de Uso");
    }

    @Override
    public void deleteById(Integer id) {
        authorRepo.deleteById(id);
    }

    @Override
    public Author updateById(Integer id, Author authorDetails) {
        throw new UnsupportedOperationException("Fuera de Uso");
    }

    public Author save(AuthorPost authorPost) {
        Author authorNew = new  Author();
        authorNew.setName(authorPost.name());
        authorNew.setLastName(authorPost.lastName());
        return authorRepo.save(authorNew);
    }
    
    public Author updateById(Integer id, AuthorPut authorPut) {
        Author existAuthor = findById(id);
        if(authorPut.name() != null){
            existAuthor.setName(authorPut.name());
        }
        if (authorPut.lastName() != null) {
            existAuthor.setLastName(authorPut.lastName());
        }
        return authorRepo.save(existAuthor);
    }
}
