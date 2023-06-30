package com.lcwp.user.service.external.service;

import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.lcwp.user.service.entities.Rating;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    //Post
    @PostMapping("/ratings")
    Rating createRating(Rating rating);

    //Put
    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable String ratingId, Rating rating);

    //Delete
    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);
}
