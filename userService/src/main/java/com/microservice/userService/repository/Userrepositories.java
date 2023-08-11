package com.microservice.userService.repository;

import com.microservice.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepositories extends JpaRepository<User, String> {

    /*If you want to implement any custom method or query you can write here*/

}
