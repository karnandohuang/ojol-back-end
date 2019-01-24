package com.day3.belajar1.repository;

import com.day3.belajar1.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    Payment findPaymentById(int id);
}
