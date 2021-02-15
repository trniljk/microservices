package com.ishara.bookingcloud.hotelservice.controller;


import com.ishara.bookingcloud.hotelservice.service.HotelService;
import com.ishara.bookingcloud.model.hotel.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/services/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;


    @PostMapping
    public Hotel save(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }

    @GetMapping(value = "/{id}")
    public Hotel getHotel(@PathVariable int id)
    {
        System.out.println("request came on "+ LocalDateTime.now());
        return hotelService.findById(id);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.findAll();
    }
}
