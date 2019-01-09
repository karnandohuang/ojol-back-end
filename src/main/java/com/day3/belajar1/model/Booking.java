package com.day3.belajar1.model;


import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BOOKING")
public class Booking {


    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Account account;
//
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Driver driver;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PAYMENT_ID", referencedColumnName = "ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Payment payment;
}
