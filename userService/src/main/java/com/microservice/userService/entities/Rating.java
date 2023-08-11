package com.microservice.userService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private String hotelId;

    private String userId;

    private int rating;

    private String feedback;

    private Hotel hotel;
}
