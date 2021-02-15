package com.ishara.bookingcloud.bookingservice.hystrix;

import com.ishara.bookingcloud.model.hotel.Hotel;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class HotelCommand extends HystrixCommand<Hotel> {
    RestTemplate restTemplate;
    int hotelId;

    public HotelCommand(RestTemplate restTemplate,int hotelId){

        super(HystrixCommandGroupKey.Factory.asKey("defult"));
        this.restTemplate=restTemplate;
        this.hotelId=hotelId;
    }

    @Override
    protected Hotel run() throws Exception {
        return restTemplate.getForObject("http://hotel/services/hotels/"+hotelId,Hotel.class);
    }

    @Override
    protected Hotel getFallback() {
        return new Hotel();
    }
}
