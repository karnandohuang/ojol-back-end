package com.day3.belajar1.repository;

import com.day3.belajar1.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    List<Booking> findAllByAccount_IdAndStatus(int accountId, String status);
    Booking deleteById(int id);
}
