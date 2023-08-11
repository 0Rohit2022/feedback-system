package com.microservice.userService.service.serviceImpl;

import com.microservice.userService.Exception.ResourceNotFoundException;
import com.microservice.userService.External.services.HotelService;
import com.microservice.userService.entities.Hotel;
import com.microservice.userService.entities.Rating;
import com.microservice.userService.entities.User;
import com.microservice.userService.repository.Userrepositories;
import com.microservice.userService.service.Userservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class Serviceimpl implements Userservice {


    @Autowired
    private Userrepositories userrepositories;
    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private HotelService hotelService;
    private Logger logger = LoggerFactory.getLogger(Serviceimpl.class);
    @Override
    public User saveUser(User user) {
        String randomUserid = UUID.randomUUID().toString();
        user.setUserId(randomUserid);

        return userrepositories.save(user);

    }


    @Override
    public List<User> getAllUsers() {
      return userrepositories.findAll();
    }

    @Override
    public User getUser(String id) {
        User user =  userrepositories.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("UserId Not Found with id " + id)
        );

        //Fetch rating of the above user from RATING METHOD
        Rating[]  ratingsofUser = restTemplate.getForObject
                ("http://RATING-SERVICE/rating/users/" +user.getUserId(),
                        Rating[].class);
        logger.info("{}", ratingsofUser);

        List<Rating> ratings = Arrays.stream(ratingsofUser)
                .collect(Collectors
                        .toList());


        List<Rating> ratingList = ratings.stream().map(rating -> {
            //Get hotels id via rating id
            //http://localhost:8082/hotels
            System.out.println(rating.getHotelId());

//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity
//                    ("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
//                            Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

//            logger.info("Response Entity status code: {} ",
//                    forEntity.getStatusCode());

            //Set the Hotel to rating
            rating.setHotel(hotel);
//          return the rating
            return  rating;

        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public void DeleteUserById(String userId) {
        userrepositories.deleteById(userId);
    }


}
