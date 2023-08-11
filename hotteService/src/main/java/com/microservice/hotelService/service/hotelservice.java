package com.microservice.hotelService.service;


import com.microservice.hotelService.entities.hotel;

import java.util.List;

public interface hotelservice {
    //Creating hotel
    hotel  createHotel(hotel hotels);


    //Listing all hotels at once
    List<hotel> getAllHotel();


    //List hotel by id
    hotel getHotelById(String id);


}
