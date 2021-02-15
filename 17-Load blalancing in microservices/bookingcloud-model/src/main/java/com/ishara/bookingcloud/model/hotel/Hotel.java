package com.ishara.bookingcloud.model.hotel;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="hotel")
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String location;
    String rating;
    int noOfRooms;
}
