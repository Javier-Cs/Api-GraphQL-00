package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.entity.Book;
import com.example.ApiGraphQLibrary.repository.BookRepo;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements CrudService<Book, Integer>{

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
    }

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book updateById(Integer id, Book book) {
         Book bookUp = bookRepo.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));

         bookUp.setTitle(book.getTitle());
         bookUp.setEditorial(book.getEditorial());
         bookUp.setYearPublic(book.getYearPublic());
         bookUp.setCode(book.getCode());
         bookUp.setEstado(book.getEstado());
         bookUp.setNumePage(book.getNumePage());

        return bookRepo.save(bookUp);
    }
}
