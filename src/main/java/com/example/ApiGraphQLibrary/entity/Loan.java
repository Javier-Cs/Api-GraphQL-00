package com.example.ApiGraphQLibrary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "loans_tbl", schema = "library")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "id_book")
    @NonNull
    int idBook;

    @Column(name = "id_user")
    @NonNull
    int idUser;

    @Column(name = "date_loan")
    @NonNull
    String datePrestamo;

    @Column(name = "date_devol_loan")
    @NonNull
    String dateDevol;

    @Column(name = "date_real_de_loan")
    @NonNull
    String dateDevolucionReal;



}
