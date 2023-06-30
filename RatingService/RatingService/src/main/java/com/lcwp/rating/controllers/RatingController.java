package com.lcwp.rating.controllers;

import com.lcwp.rating.entities.Rating;
import com.lcwp.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //Create ratings
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //Get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings()
    {
        return ResponseEntity.ok(ratingService.getRatings());
    }

    //get ratings by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserID(@PathVariable String userId)
    {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    //get ratings by hotelId
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelID(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}
