package com.example.ApiGraphQLibrary.entity;

import com.example.ApiGraphQLibrary.info.Mss;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "books_tbl", schema = "library")
public  class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = Mss.notN_E)
    @Size(max = 60)
    private String title;

    @Size(max = 6)
    private int yearPublic;

    @NotBlank(message = Mss.notN_E)
    @Size(max = 50)
    private String editorial;

    @NotBlank(message = Mss.notN_E)
    @Size(max = 100)
    private String code;

    @Column(name = "state")
    private boolean estado;

    private int numePage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan>  loans;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserv>  reservs;
}
