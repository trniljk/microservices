package com.ishara.bookingcloud.bookingservice.controller;

import com.ishara.bookingcloud.bookingservice.model.Response;
import com.ishara.bookingcloud.bookingservice.model.SimpleResponse;
import com.ishara.bookingcloud.bookingservice.service.BookingService;
import com.ishara.bookingcloud.model.booking.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services/booking")
public class BookingController {


    @Autowired
    BookingService bookingService;

    @PostMapping
    public Booking save(@RequestBody  Booking booking) {

        return bookingService.save(booking);
    }

    @GetMapping(value = "/{id}")
    public Response getBooking(@PathVariable int id, @RequestParam(required = false) String type) {

        if(type==null){
            return  new SimpleResponse(bookingService.findById(id));
        }else{
            return    bookingService.findDetailResponse(id);
        }

    }
    @GetMapping
    public List<Booking> getAllBooking() {

        return bookingService.findAll();
    }


}

