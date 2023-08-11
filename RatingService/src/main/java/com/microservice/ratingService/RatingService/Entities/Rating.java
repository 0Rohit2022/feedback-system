package com.microservice.ratingService.RatingService.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rating_micro")
public class Rating {

    @Id
    private String ratingId;
    private String hotelId;
    private String userId;
    private int rating;
    private String feedback;

}
