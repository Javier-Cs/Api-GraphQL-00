package com.example.ApiGraphQLibrary.dto;

import java.time.LocalDate;

public record LoanPut(
        LocalDate dateDevol,
        LocalDate dateDevolucionReal
) {
}
