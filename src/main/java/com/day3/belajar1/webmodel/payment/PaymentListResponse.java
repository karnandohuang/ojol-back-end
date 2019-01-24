package com.day3.belajar1.webmodel.payment;

import com.day3.belajar1.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaymentListResponse{
    List<Payment> data;

}
