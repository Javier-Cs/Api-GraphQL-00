package com.example.ApiGraphQLibrary.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "loans_tbl", schema = "library")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_loan")
    private LocalDate datePrestamo;

    @Column(name = "date_devol_loan")
    private LocalDate dateDevol;

    @Column(name = "date_real_de_loan")
    private LocalDate dateDevolucionReal;

    @JoinColumn(name = "id_book")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @JoinColumn(name = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
