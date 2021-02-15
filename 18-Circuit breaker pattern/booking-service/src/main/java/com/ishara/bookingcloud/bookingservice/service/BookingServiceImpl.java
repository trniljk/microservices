package com.ishara.bookingcloud.bookingservice.service;

import com.ishara.bookingcloud.bookingservice.hystrix.CommonHysctrixCommand;
import com.ishara.bookingcloud.bookingservice.hystrix.HotelCommand;
import com.ishara.bookingcloud.bookingservice.model.DetailResponse;
import com.ishara.bookingcloud.bookingservice.repository.BookingRepository;
import com.ishara.bookingcloud.model.booking.Booking;
import com.ishara.bookingcloud.model.customer.Customer;
import com.ishara.bookingcloud.model.hotel.Hotel;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ishara.bookingcloud.model.booking.Booking;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    HystrixCommand.Setter setter;

    @LoadBalanced
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
//    @HystrixCommand(fallbackMethod = "findDetailResponsefallback")
    public DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException {
        Booking booking=findById(id);
        Customer customer=getCustomer(booking.getCustomerId());
        //Customer customer=restTemplate.getForObject("http://customer/services/customers/"+id,Customer.class);
        Hotel hotel= getHotel(booking.getHotelId());

        return new DetailResponse(hotel,booking,customer);
    }

//    public DetailResponse findDetailResponsefallback(int id) {
//        return new DetailResponse(new Hotel(),new Booking(),new Customer());
//    }


    private Customer getCustomer(int customerId) throws ExecutionException, InterruptedException {

        CommonHysctrixCommand<Customer> customerCommonHysctrixCommand = new CommonHysctrixCommand<Customer>(setter,()->{
            return restTemplate.getForObject("http://customer/services/customers/"+customerId,Customer.class);
        },()->{
            return new Customer();
        });

        Future<Customer> customerFuture = customerCommonHysctrixCommand.queue();
        return customerFuture.get();


//
//        Customer customer=restTemplate.getForObject("http://customer/services/customers/"+customerId,Customer.class);
//        return customer;
    }
    private Hotel getHotel(int hotelId){

        HotelCommand hotelCommand = new HotelCommand(restTemplate,hotelId);
        //Hotel hotel = restTemplate.getForObject("http://hotel/services/hotels/"+hotelId,Hotel.class);
        return hotelCommand.execute();
    }

}
