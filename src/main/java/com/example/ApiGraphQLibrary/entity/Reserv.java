package com.example.ApiGraphQLibrary.entity;

import com.example.ApiGraphQLibrary.info.Mss;
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
@Table(name = "reserv_tbl", schema = "library")
public class Reserv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = Mss.notN_E)
    private String status;

    @NotEmpty
    @Column(name = "date_res")
    private LocalDate dateReserv;

    @JoinColumn(name = "id_book")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @JoinColumn(name = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
