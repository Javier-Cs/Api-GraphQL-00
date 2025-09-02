package com.example.ApiGraphQLibrary.repository;

import com.example.ApiGraphQLibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
