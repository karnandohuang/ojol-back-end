package com.day3.belajar1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

//    @Column(name = "NAME")
    private String name;

//    @Column(name = "BALANCE")
    private int balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Booking> bookingList;

}
