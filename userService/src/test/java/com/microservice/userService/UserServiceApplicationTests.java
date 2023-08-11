package com.microservice.userService;

import com.microservice.userService.External.services.RatingService;
import com.microservice.userService.entities.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignClient;


@SpringBootTest

class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;
	@Test
	void contextLoads() {
	}

	@Test
	 void createRating()
	{
		Rating ratings = Rating.builder().rating(10).userId("1").hotelId("12").feedback("This is create using feign client").build();
		Rating rating = ratingService.createRating(ratings);
		System.out.println("Rating has been created " );

	}



}
