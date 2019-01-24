package com.day3.belajar1.service;

import com.day3.belajar1.model.Booking;
import com.day3.belajar1.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getBookingList() throws Exception{
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingListHistory(int accountId, String status) throws Exception{
        return bookingRepository.findAllByAccount_IdAndStatus(accountId, status);
    }

    public Booking saveBooking(Booking booking) throws Exception{
        return bookingRepository.save(booking);
    }

    public Booking deleteBooking(int id) throws Exception{
        return bookingRepository.deleteById(id);
    }
}
