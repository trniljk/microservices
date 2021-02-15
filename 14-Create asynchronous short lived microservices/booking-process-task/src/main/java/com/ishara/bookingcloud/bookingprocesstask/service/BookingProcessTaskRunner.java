package com.ishara.bookingcloud.bookingprocesstask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

public class BookingProcessTaskRunner implements CommandLineRunner {

    @Autowired
    BookingProcessService bookingProcessService;

    @Override
    public void run(String... args) throws Exception {

        if(args.length>0){
            System.out.println("task Running with arguments");
            if(bookingProcessService.validateEmail(args[0])){
                System.out.println("Valid Email");
            }else{
                System.out.println("Invalid Email");
            }
        }else
            System.out.println("task running without args");



    }
}
