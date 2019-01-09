package com.day3.belajar1.controller;

import com.day3.belajar1.model.Payment;
import com.day3.belajar1.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/payments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> getPaymentList(){
        try {
            return paymentService.getPaymentList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
