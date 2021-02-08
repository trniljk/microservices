package com.ishara.hotelBooking.controller;

import com.ishara.hotelBooking.model.Customer;
import com.ishara.hotelBooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String greeting() {

        return "Hello Spring Boot";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String greeting2() {
        return "Hello Spring Boot from POST";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {

        return customerService.save(customer);
    }
    @RequestMapping(value = "/customer",method = RequestMethod.GET)
    public ResponseEntity<Customer> fetchCustomer(@RequestParam int id){

        Customer customer= customerService.fetchCustomerById(id);
        if(customer==null){
            return   ResponseEntity.notFound().build();
        }else{
            return  ResponseEntity.ok().body(customer);
        }
    }

}
