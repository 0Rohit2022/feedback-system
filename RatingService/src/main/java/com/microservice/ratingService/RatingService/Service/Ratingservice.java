package com.microservice.ratingService.RatingService.Service;

import com.microservice.ratingService.RatingService.Entities.Rating;

import java.util.List;

public interface Ratingservice {

    //Create Rating
    Rating create (Rating rating);

    //Get All RAtings
    List<Rating> getAllRatings();

    // Get All Ratings By UserId
    List<Rating> getRatingsByUserId(String userId);

    //Get All Ratings By HotelId
    List<Rating> getRatingsByHotelId(String hotelId);
}
