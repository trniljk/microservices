package com.ishara.bookingcloud.bookingprocesstask.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BookingProcessServiceImpl implements BookingProcessService {



    @Override
    public boolean validateEmail(String email){

        return (0<=email.indexOf('@'));
    }
}
