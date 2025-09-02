package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.entity.Author;
import com.example.ApiGraphQLibrary.entity.Reserv;
import com.example.ApiGraphQLibrary.repository.ReservRepo;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservService implements CrudService<Reserv, Integer>{
    private final ReservRepo reservRepo;

    public ReservService(ReservRepo reservRepo) {
        this.reservRepo = reservRepo;
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
        return reservRepo.save(reserv);
    }

    @Override
    public void deleteById(Integer id) {
        reservRepo.deleteById(id);
    }

    @Override
    public Reserv updateById(Integer id, Reserv reserv) {
        Reserv reservUp = reservRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserv Not Found"));

        reservUp.setDateReserv(reserv.getDateReserv());
        reservUp.setStatus(reserv.getStatus());
        return reservRepo.save(reservUp);
    }
}
