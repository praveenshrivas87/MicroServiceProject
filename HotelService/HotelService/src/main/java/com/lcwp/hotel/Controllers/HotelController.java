package com.lcwp.hotel.Controllers;

import com.lcwp.hotel.entities.Hotel;
import com.lcwp.hotel.services.HotelService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(hotelService.get(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel()
    {
        return ResponseEntity.ok(hotelService.getAll());
    }
}
