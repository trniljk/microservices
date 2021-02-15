package com.ishara.bookingcloud.bookingservice.model;

import com.ishara.bookingcloud.model.booking.Booking;

public class SimpleResponse implements Response{
    Booking booking;

    public SimpleResponse(Booking booking) {
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
