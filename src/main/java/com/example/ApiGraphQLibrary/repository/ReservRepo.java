package com.example.ApiGraphQLibrary.repository;

import com.example.ApiGraphQLibrary.entity.Reserv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservRepo  extends JpaRepository<Reserv, Integer> {
}
