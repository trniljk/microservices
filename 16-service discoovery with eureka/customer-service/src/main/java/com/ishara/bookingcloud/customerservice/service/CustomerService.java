package com.ishara.bookingcloud.customerservice.service;

import com.ishara.bookingcloud.model.customer.Customer;

import java.util.List;


public interface CustomerService {
    Customer save(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();
}
