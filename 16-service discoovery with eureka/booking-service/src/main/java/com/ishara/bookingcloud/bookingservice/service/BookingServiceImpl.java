package com.ishara.bookingcloud.bookingservice.service;

import com.ishara.bookingcloud.bookingservice.model.DetailResponse;
import com.ishara.bookingcloud.bookingservice.repository.BookingRepository;
import com.ishara.bookingcloud.model.booking.Booking;
import com.ishara.bookingcloud.model.customer.Customer;
import com.ishara.bookingcloud.model.hotel.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ishara.bookingcloud.model.booking.Booking;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder){

        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Booking save(Booking customer) {

        return bookingRepository.save(customer);
    }

    @Override
    public Booking findById(int id) {
        Optional<Booking> booking = bookingRepository.findById(id);

        if (booking.isPresent())
            return booking.get();
        else
            return new Booking();
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public DetailResponse findDetailResponse(int id) {
        Booking booking=findById(id);
        Customer customer=getCustomer(booking.getCustomerId());
        Hotel hotel= getHotel(booking.getHotelId());

        return new DetailResponse(hotel,booking,customer);
    }


    private Customer getCustomer(int customerId){

        Customer customer=restTemplate.getForObject("http://localhost:8080/services/customers/"+customerId,Customer.class);
        return customer;
    }
    private Hotel getHotel(int hotelId){
        Hotel hotel = restTemplate.getForObject("http://localhost:9191/services/hotels/"+hotelId,Hotel.class);
        return hotel;
    }

}
