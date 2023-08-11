package com.microservice.ratingService.RatingService.Repository;

import com.microservice.ratingService.RatingService.Entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Ratingrepostories extends JpaRepository<Rating, String> {

    //custom find methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
