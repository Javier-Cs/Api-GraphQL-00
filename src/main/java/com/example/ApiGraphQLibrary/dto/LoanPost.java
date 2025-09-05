package com.example.ApiGraphQLibrary.dto;

import java.time.LocalDate;

public record LoanPost(
        String datePrestamo,
        String dateDevol,
        String dateDevolucionReal,
        Integer id_book,
        Integer id_user
) {
}
