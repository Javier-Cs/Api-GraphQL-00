package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.dto.ReservPost;
import com.example.ApiGraphQLibrary.dto.ReservPut;
import com.example.ApiGraphQLibrary.entity.Author;
import com.example.ApiGraphQLibrary.entity.Reserv;
import com.example.ApiGraphQLibrary.info.tools.Tools;
import com.example.ApiGraphQLibrary.repository.BookRepo;
import com.example.ApiGraphQLibrary.repository.ReservRepo;
import com.example.ApiGraphQLibrary.repository.UserRepo;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservService implements CrudService<Reserv, Integer>{
    private final ReservRepo reservRepo;
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public ReservService(ReservRepo reservRepo, BookRepo bookRepo, UserRepo userRepo) {
        this.reservRepo = reservRepo;
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Reserv> findAll() {
        return reservRepo.findAll();
    }

    @Override
    public Reserv findById(Integer id) {
        return reservRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserv Not Found"));
    }

    @Override
    public Reserv save(Reserv reserv) {
        throw new UnsupportedOperationException("Fuera de Uso");
    }

    @Override
    public void deleteById(Integer id) {
        reservRepo.deleteById(id);
    }

    @Override
    public Reserv updateById(Integer id, Reserv reserv) {
        throw new UnsupportedOperationException("Fuera de Uso");
    }

    public Reserv save(ReservPost reservPost) {
        Reserv reservNew = new Reserv();
        reservNew.setStatus(reservPost.status());
        reservNew.setDateReserv(Tools.converStr_Date(reservPost.dateReserv()));

        reservNew.setBook(bookRepo.findById(reservPost.id_book()).orElseThrow(
                () -> new ResourceNotFoundException("Book Not Found")
        ));
        reservNew.setUser(userRepo.findById(reservPost.id_user()).orElseThrow(
                () -> new ResourceNotFoundException("User Not Found")
        ));
        return  reservRepo.save(reservNew);
    }

    public Reserv updateById(Integer id, ReservPut reservPut) {
        Reserv reservUpdate = findById(id);
        if (reservPut.status() != null) {
            reservUpdate.setStatus(reservPut.status());
        }
        return reservRepo.save(reservUpdate);
    }
}
