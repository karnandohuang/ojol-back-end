package com.day3.belajar1.service;

import com.day3.belajar1.model.Payment;
import com.day3.belajar1.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> getPaymentList() throws Exception{
        return paymentRepository.findAll();
    }

    public Payment savePayment(Payment payment) throws Exception {
        return paymentRepository.save(payment);
    }

    public Payment getPayment(int id) throws Exception {
        return paymentRepository.findPaymentById(id);
    }

}
