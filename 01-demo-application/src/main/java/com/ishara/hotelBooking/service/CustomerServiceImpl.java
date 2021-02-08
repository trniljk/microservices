package com.ishara.hotelBooking.service;

import com.ishara.hotelBooking.model.Customer;
import com.ishara.hotelBooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }


    public Customer fetchCustomerById(int id){


        Optional<Customer> customer=    customerRepository.findById( id);
        if(customer.isPresent()){
            return customer.get();
        }
        return null;

    }
}
