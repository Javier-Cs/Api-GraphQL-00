package com.example.ApiGraphQLibrary.dto;

public record BookPut(
        //int id,
        String title,
        int yearPublic,
        String editorial,
        String code,
        boolean estado,
        int numePage
) {
}
