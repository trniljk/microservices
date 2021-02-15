package com.ishara.bookingcloud.customerservice.repository;

import com.ishara.bookingcloud.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
