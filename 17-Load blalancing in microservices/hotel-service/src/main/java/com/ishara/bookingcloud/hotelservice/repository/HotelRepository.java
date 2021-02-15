package com.ishara.bookingcloud.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ishara.bookingcloud.model.hotel.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {

}
