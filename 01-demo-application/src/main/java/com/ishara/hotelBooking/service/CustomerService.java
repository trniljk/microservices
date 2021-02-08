package com.ishara.hotelBooking.service;

import com.ishara.hotelBooking.model.Customer;

public interface CustomerService {
    Customer save(Customer customer);
    public Customer fetchCustomerById(int id);
}
