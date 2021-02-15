package com.ishara.bookingcloud.profileservice.service;

import com.ishara.bookingcloud.commons.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);

    Customer fetchById(int customerId);

    List<Customer> fetchAllProfiles();
}
