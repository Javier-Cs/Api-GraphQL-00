package com.example.ApiGraphQLibrary.service;

import com.example.ApiGraphQLibrary.dto.UserPost;
import com.example.ApiGraphQLibrary.dto.UserPut;
import com.example.ApiGraphQLibrary.entity.User;
import com.example.ApiGraphQLibrary.info.tools.Tools;
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
        throw new UnsupportedOperationException("Fuera de Uso");
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public User updateById(Integer id, User userDetails) {
        throw new UnsupportedOperationException("Fuera de Uso");
    }

    public User save(UserPost userPost) {
        User userNew = new User();
        userNew.setName(userPost.name());
        userNew.setLastName(userPost.lastName());
        userNew.setEmail(userPost.email());
        userNew.setDateRegistrer(Tools.converStr_Date(userPost.dateRegistrer()));

        return userRepo.save(userNew);
    }


    public User updateById(Integer id, UserPut userPut) {
        User userUpdate = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + id + " not found")
        );
        if (userPut.name() != null) {
            userUpdate.setName(userPut.name());
        }
        if (userPut.lastName() != null) {
            userUpdate.setLastName(userPut.lastName());
        }
        if (userPut.email() != null) {
            userUpdate.setEmail(userPut.email());
        }
        return userRepo.save(userUpdate);
    }
}
