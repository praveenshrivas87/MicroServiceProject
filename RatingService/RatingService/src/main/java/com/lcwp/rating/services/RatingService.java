package com.lcwp.rating.services;

import com.lcwp.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    //Create
    Rating create(Rating rating);

    //get all ratings
    List<Rating> getRatings();

    //get rating by userId
    List<Rating> getRatingByUserId(String userId);

    //get rating by hotelId
    List<Rating> getRatingByHotelId(String hotelId);
}
