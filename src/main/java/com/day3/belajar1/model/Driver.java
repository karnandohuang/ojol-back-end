package com.day3.belajar1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "DRIVER")
public class Driver {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    private String name;
    private int balance;
    private String vehicleNumber;

}
