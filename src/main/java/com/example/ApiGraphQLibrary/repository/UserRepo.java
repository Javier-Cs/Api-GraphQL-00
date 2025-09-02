package com.example.ApiGraphQLibrary.repository;

import com.example.ApiGraphQLibrary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
