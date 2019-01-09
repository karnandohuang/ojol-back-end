package com.day3.belajar1.controller;

import com.day3.belajar1.model.Booking;
import com.day3.belajar1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(value = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Booking> getBookingList(){
        List<Booking> bookingList = null;

        try {
            bookingList = bookingService.getBookingList();
            return bookingList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(value = "/bookings/history/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Booking> getBookingListHistory(@PathVariable("status") String status){
        List<Booking> bookingList = null;

        try {
            bookingList = bookingService.getBookingListHistory(status);
            return bookingList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping(value = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Booking saveBooking(@RequestBody Booking request){
        try {
            return bookingService.saveBooking(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
