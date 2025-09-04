package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.dto.BookPost;
import com.example.ApiGraphQLibrary.dto.BookPut;
import com.example.ApiGraphQLibrary.entity.Author;
import com.example.ApiGraphQLibrary.entity.Book;
import com.example.ApiGraphQLibrary.repository.AuthorRepo;
import com.example.ApiGraphQLibrary.repository.BookRepo;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements CrudService<Book, Integer>{

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
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
        throw new UnsupportedOperationException("Use createBook(BookPost) instead");
    }

    @Override
    public void deleteById(Integer id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book updateById(Integer id, Book book) {
        throw new UnsupportedOperationException("Use updateBook(id, BookPut) instead");
    }

    public Book save(BookPost bookPost) {
        Author author = authorRepo.findById(bookPost.id_autor())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        Book bookNew = new  Book();
        bookNew.setTitle(bookPost.title());
        bookNew.setYearPublic(bookPost.yearPublic());
        bookNew.setEditorial(bookPost.editorial());
        bookNew.setCode(bookPost.code());
        bookNew.setEstado(bookPost.estado());
        bookNew.setNumePage(bookPost.numePage());
        bookNew.setAuthor(author);
        return bookRepo.save(bookNew);
    }

    public Book updateById(Integer id, BookPut  bookPut ) {
        Book existBook = findById(id);

        if(bookPut.title() != null && !bookPut.title().isEmpty()){
            existBook.setTitle(bookPut.title());

        if (bookPut.yearPublic() != null && !bookPut.editorial().isEmpty()){
        existBook.setYearPublic(bookPut.yearPublic());}
        }
        if (bookPut.editorial() != null && !bookPut.editorial().isEmpty()){
            existBook.setEditorial(bookPut.editorial());
        }
        if (bookPut.code()!= null && !bookPut.code().isEmpty()){
            existBook.setCode(bookPut.code());
        }
        if (bookPut.estado() != null ){
            existBook.setEstado(bookPut.estado());
        }
        if (bookPut.numePage() != null){
            existBook.setNumePage(bookPut.numePage());
        }

        return bookRepo.save(existBook);
    }

}
