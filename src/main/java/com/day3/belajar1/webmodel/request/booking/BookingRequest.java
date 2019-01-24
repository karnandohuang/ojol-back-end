package com.day3.belajar1.webmodel.request.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingRequest {
    private int id;
    private int accountId;
    private int driverId;
    private String status;
    private int paymentId;
    private int price;
}
