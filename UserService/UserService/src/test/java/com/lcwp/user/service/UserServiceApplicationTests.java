package com.lcwp.user.service;

import com.lcwp.user.service.entities.Rating;
import com.lcwp.user.service.external.service.RatingService;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	@Test
	void createRating() {
		Rating rating = Rating.builder().userId("").hotelId("").rating(10).feedBack("Very Good : From Feing Client").build();
		ratingService.createRating(rating);
		System.out.println("New rating created from Feign Client");
	}

}
