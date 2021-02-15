package com.ishara.bookingcloud.bookingservice.repository;

import com.ishara.bookingcloud.model.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
