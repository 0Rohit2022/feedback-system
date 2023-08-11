package com.microservice.userService.service;

import com.microservice.userService.entities.User;

import java.util.List;

public interface Userservice {
    /*Create method that extends serviceImpl class*/


    /*Create User*/
    User  saveUser(User user);


    /*GEt All User*/
    List<User> getAllUsers();

    //Get single user by given id
    User getUser(String id);


    //Delete all user
    void DeleteUserById(String userId);
    //And if you want then you can create update and delete also


}
