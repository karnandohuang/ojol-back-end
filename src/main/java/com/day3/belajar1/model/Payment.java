package com.day3.belajar1.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    private String name;
}
