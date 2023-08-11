package com.microservice.userService.External.services;

import com.microservice.userService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    //Create method for rating
    @PostMapping("/rating")
    Rating createRating(Rating rating);

    //Get Method for rating


    //Put method for rating
    @PutMapping("/rating/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    //Delete Method for rating
//    @DeleteMapping("/rating/{ratingId")
//    void deleteRating(@PathVariable("ratingId") String ratingId);
}
