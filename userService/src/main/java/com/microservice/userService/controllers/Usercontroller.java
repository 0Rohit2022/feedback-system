package com.microservice.userService.controllers;

import com.microservice.userService.entities.User;
import com.microservice.userService.service.Userservice;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    private Userservice userservice;



    private Logger logger = LoggerFactory.getLogger(Usercontroller.class);

    //Craate user method
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody  User user)
    {
        User user1 = userservice.saveUser(user);

       return new ResponseEntity<>(user1, HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable("userId") String userId)
    {
        userservice.DeleteUserById(userId);
    }

    int retryCount = 1;
    //Get User by id
//    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")

//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelfallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelfallback")
@RateLimiter(name = "userratelimiter", fallbackMethod = "ratingHotelfallback")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id)
    {
        logger.info("Retry Count {} : " + retryCount);
        retryCount++;
        //Getting user by id
       User user =  userservice.getUser(id);

       return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> ratingHotelfallback(String userId, Exception ex)
    {
//        ex.printStackTrace();
        logger.info("FAllback is executed because service is down :" + ex.getMessage());
        User user = User.builder()
                .name("ServiceError")
                .about("This message occured because one of the service is down")
                .userId("1")
                .build();
        return new ResponseEntity<>(user, HttpStatus.TOO_MANY_REQUESTS);
    }



    //All User get method
        @GetMapping
    public ResponseEntity<List<User>> getAllUser()
        {
            List<User> allUser = userservice.getAllUsers();
           return ResponseEntity.ok(allUser);
        }


}
