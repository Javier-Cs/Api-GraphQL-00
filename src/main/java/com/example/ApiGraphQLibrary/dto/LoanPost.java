package com.example.ApiGraphQLibrary.dto;

import java.time.LocalDate;

public record LoanPost(
        LocalDate datePrestamo,
        LocalDate dateDevol,
        LocalDate dateDevolucionReal,
        int id_book,
        int id_user
) {
}
