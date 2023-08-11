package com.microservice.ratingService.RatingService.Service.Serviceimpl;

import com.microservice.ratingService.RatingService.Entities.Rating;
import com.microservice.ratingService.RatingService.Repository.Ratingrepostories;
import com.microservice.ratingService.RatingService.Service.Ratingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@Service
public class RatingserviceImpl implements Ratingservice {

    @Autowired
    private Ratingrepostories ratingrepostories;
    @Override
    public Rating create(Rating rating) {
        String randomID = UUID.randomUUID().toString();
        rating.setRatingId(randomID);
        return ratingrepostories.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
       return ratingrepostories.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingrepostories.findByUserId(userId);

    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
         return ratingrepostories.findByHotelId(hotelId);
    }
}
