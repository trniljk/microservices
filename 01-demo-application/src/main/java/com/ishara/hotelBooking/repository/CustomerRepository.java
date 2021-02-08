package com.ishara.hotelBooking.repository;

import com.ishara.hotelBooking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer,Integer>{


}
