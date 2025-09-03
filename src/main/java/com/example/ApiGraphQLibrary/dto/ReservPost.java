package com.example.ApiGraphQLibrary.dto;

import java.time.LocalDate;

public record ReservPost(
        String status,
        LocalDate dateReserv,
        int id_book,
        int id_user
) {
}
