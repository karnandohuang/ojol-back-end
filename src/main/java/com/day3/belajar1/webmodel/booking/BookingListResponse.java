package com.day3.belajar1.webmodel.booking;

import com.day3.belajar1.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookingListResponse {

    List<Booking> data;
}
