package com.ishara.bookingcloud.model.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String firstName;
    private String lastName;
    private String email;
    private String country;
    @OneToMany(mappedBy = "customer")
    private List<Loyality> loyalities;

}
