package com.ishara.bookingcloud.bookingservice.model;

import com.ishara.bookingcloud.model.booking.Booking;
import com.ishara.bookingcloud.model.customer.Customer;
import com.ishara.bookingcloud.model.hotel.Hotel;

public class DetailResponse implements Response{
    Hotel hotel;
    Booking booking;
    Customer customer;

    public DetailResponse(Hotel hotel, Booking booking, Customer customer) {
        this.hotel = hotel;
        this.booking = booking;
        this.customer = customer;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
