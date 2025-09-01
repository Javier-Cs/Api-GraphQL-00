package com.example.ApiGraphQLibrary.entity;

import com.example.ApiGraphQLibrary.info.Mss;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "authors_tbl", schema = "library")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = Mss.notN_E)
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank(message = Mss.notN_E)
    @Size(min =1, max = 100)
    @Column(name = "last_Name")
    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;
}
