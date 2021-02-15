package com.ishara.bookingcloud.hotelservice.service;
import com.ishara.bookingcloud.model.hotel.Hotel;

import java.util.List;

public interface HotelService {

    Hotel save(Hotel cutomer);
    Hotel findById(int id);
    List<Hotel> findAll();

}
