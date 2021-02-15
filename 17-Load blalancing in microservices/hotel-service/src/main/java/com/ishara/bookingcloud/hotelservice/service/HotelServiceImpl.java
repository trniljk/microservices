package com.ishara.bookingcloud.hotelservice.service;


import com.ishara.bookingcloud.hotelservice.repository.HotelRepository;
import com.ishara.bookingcloud.model.hotel.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel cutomer) {
        return hotelRepository.save(cutomer);
    }

    @Override
    public Hotel findById(int id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);

        if (hotel.isPresent())
            return hotel.get();
        else
            return new Hotel();
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
}
