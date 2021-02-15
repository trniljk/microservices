package com.ishara.bookingcloud.model.booking;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookingId;
    int customerId;
    int hotelId;
    LocalDateTime bookingFrom;
    LocalDateTime bookingTo;
    String roomType;
    int numberOfPersons;
}
