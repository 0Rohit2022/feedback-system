package com.microservice.ratingService.RatingService.Controller;

import com.microservice.ratingService.RatingService.Entities.Rating;
import com.microservice.ratingService.RatingService.Service.Ratingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private Ratingservice ratingservice;
    @PreAuthorize("hasAuthority ('Admin')")
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        Rating ratings = ratingservice.create(rating);
        return new ResponseEntity<>(ratings, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings()
    {
        List<Rating> ratings = ratingservice.getAllRatings();
        return  new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin') ")
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId)
    {
        List<Rating> ratings = ratingservice.getRatingsByUserId(userId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId)
    {
        List<Rating> ratings = ratingservice.getRatingsByHotelId(hotelId);
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }


}
