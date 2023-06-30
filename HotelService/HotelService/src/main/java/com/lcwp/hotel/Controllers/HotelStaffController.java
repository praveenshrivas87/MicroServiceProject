package com.lcwp.hotel.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/hotelStaffs")
public class HotelStaffController {

    @GetMapping
    public ResponseEntity<List<String>> getHotelStaff()
    {
        List<String> list = Arrays.asList("Ram", "Laxman", "Sita", "Hanuman");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
