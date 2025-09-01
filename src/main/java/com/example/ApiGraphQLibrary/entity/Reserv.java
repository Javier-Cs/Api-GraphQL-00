package com.example.ApiGraphQLibrary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "loans_tbl", schema = "library")
public class Reserv {
    @Id
    int id;

    @Column(name = "id_book")
    @NonNull
    int idBook;

    @Column(name = "id_user")
    @NonNull
    int idUser;

    @NonNull
    String status;

    @NonNull
    String date_res;

}
