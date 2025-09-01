package com.example.ApiGraphQLibrary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reserv_tbl", schema = "library")
public class Reserv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String status;

    @NonNull
    private String date_res;

    @JoinColumn(name = "id_book")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @JoinColumn(name = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
