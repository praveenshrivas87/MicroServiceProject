package com.lcwp.user.service.external.service;

import com.lcwp.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/{hid}")
    Hotel getHotel(@PathVariable("hid") String hotelId);
}
