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
    private int id;

    @Column(name = "date_loan")
    @NonNull
    private String datePrestamo;

    @Column(name = "date_devol_loan")
    @NonNull
    private String dateDevol;

    @Column(name = "date_real_de_loan")
    private String dateDevolucionReal;

    @JoinColumn(name = "id_book")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @JoinColumn(name = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
