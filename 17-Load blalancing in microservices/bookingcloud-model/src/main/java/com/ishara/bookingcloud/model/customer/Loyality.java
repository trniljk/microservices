package com.ishara.bookingcloud.model.customer;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loyalityReward")
@Data
public class Loyality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int receiptId;

    @ManyToOne
    @JoinColumn
    Customer customer;

    int point;
    String offer;
    LocalDateTime expireDate;
}
