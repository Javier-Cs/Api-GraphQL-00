package com.example.ApiGraphQLibrary.dto;

import java.time.LocalDate;

public record ReservPost(
        String status,
        String dateReserv,
        Integer id_book,
        Integer id_user
) {
}
