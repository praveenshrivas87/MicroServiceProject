package com.lcwp.user.service.services.impl;

import com.lcwp.user.service.entities.Hotel;
import com.lcwp.user.service.entities.Rating;
import com.lcwp.user.service.entities.User;
import com.lcwp.user.service.exceptions.ResourceNotFoundException;
import com.lcwp.user.service.external.service.HotelService;
import com.lcwp.user.service.repositories.UserRepository;
import com.lcwp.user.service.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    //private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user) ;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    //get single user
    @Override
    public User getUser(String userId) {
        //Get single user from database with the help of repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server! " + userId));
        // fetch rating fot the above user from RATING SERVICE
        //http://localhost:8083/ratings/users/920c42d7-4f81-4c7f-9be5-d6fafcc2eb0c
        Rating[] ratingsByUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        //logger.info("{}" + ratingsByUser);

        List<Rating> ratings = Arrays.stream(ratingsByUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get hotel
            //http://localhost:8082/hotels/0db93a85-337d-4d55-8a27-e7814d047999

            //the below line of code is used to call HOTEL SERVICE using RestTemplate
           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
           // Hotel hotel = forEntity.getBody();

            //The below line of code is used to call HOTEL SERVICE using FEIGN CLIENT
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            //set the hotel to rating
            rating.setHotel(hotel);
            //return rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratings);
        return user;
    }
}
