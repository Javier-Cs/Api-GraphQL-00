package com.example.ApiGraphQLibrary.dto;

public record BookPost(

        String title,
        int yearPublic,
        String editorial,
        String code,
        boolean estado,
        int numePage,
        int id_autor

) {
}
