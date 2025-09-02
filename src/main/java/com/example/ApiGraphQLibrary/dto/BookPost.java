package com.example.ApiGraphQLibrary.dto;

public record BookPost(
        //int id,
        String title,
        int yearPublic,
        String editorial,
        String code,
        boolean estado,
        int numePage,
        int id_autor

) {
}
