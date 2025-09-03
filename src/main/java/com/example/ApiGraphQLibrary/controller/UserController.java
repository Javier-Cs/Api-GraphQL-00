package com.example.ApiGraphQLibrary.controller;

import com.example.ApiGraphQLibrary.dto.ReservPost;
import com.example.ApiGraphQLibrary.dto.ReservPut;
import com.example.ApiGraphQLibrary.dto.UserPost;
import com.example.ApiGraphQLibrary.dto.UserPut;
import com.example.ApiGraphQLibrary.entity.Reserv;
import com.example.ApiGraphQLibrary.entity.User;
import com.example.ApiGraphQLibrary.service.UserServiceImp;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }


    @QueryMapping
    public List<User> listarUser() {
        return userServiceImp.findAll();
    }

    @QueryMapping
    public User listarUserById(@Argument int id) {
        return userServiceImp.findById(id);
    }

    @MutationMapping
    public User createUser(@Argument UserPost userPost){
        User userNew = new User();
        userNew.setName(userPost.name());
        userNew.setLastName(userPost.lastName());
        userNew.setEmail(userPost.email());

        return userServiceImp.save(userNew);
    }

    @MutationMapping
    public User updateUser(@Argument int id, @Argument UserPut userPut){
        User userUpdate = new User();
        userUpdate.setName(userPut.name());
        userUpdate.setLastName(userPut.lastName());
        userUpdate.setEmail(userPut.email());

        return  userServiceImp.updateById(id,userUpdate);
    }

    @MutationMapping
    public void deleteUser(@Argument Integer id){
        userServiceImp.deleteById(id);
    }
}
