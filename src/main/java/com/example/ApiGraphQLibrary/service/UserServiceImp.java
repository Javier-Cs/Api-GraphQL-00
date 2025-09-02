package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.entity.User;
import com.example.ApiGraphQLibrary.repository.UserRepo;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements CrudService<User, Integer> {

    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + id + " not found")
        );
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public User updateById(Integer id, User userDetails) {
        User userUp = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userUp.setName(userDetails.getName());
        userUp.setLastName(userDetails.getLastName());
        userUp.setEmail(userDetails.getEmail());

        return userRepo.save(userUp);
    }
}
