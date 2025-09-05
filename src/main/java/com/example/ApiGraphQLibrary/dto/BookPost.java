package com.example.ApiGraphQLibrary.dto;

public record BookPost(

        String title,
        Integer yearPublic,
        String editorial,
        String code,
        Boolean estado,
        Integer numePage,
        Integer id_autor

) {
}
