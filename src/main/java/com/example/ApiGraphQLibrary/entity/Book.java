package com.example.ApiGraphQLibrary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "books_tbl", schema = "library")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NonNull
    String title;

    @NonNull
    int yearPublic;

    @NonNull
    String editorial;

    @NonNull
    String code;

    @Column(name = "id_user")
    @NonNull
    byte estado;

    @NonNull
    int numPage;

    @Column(name = "id_autor")
    @NonNull
    int idAutor;




}
