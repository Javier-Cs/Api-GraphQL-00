package com.example.ApiGraphQLibrary.entity;

import com.example.ApiGraphQLibrary.info.Mss;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users_tbl", schema = "library")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = Mss.notN_E)
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank(message = Mss.notN_E)
    @Size(min = 1, max = 100)
    private String lastName;


    @Email(message = "ingrese un correo valido")
    @NotBlank(message = Mss.notN_E)
    @Size(min = 1, max = 50)
    private String email;

    @Column(name = "date_Regis")
    @NotEmpty
    private LocalDate dateRegistrer;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans;

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserv>  reserves;
}
