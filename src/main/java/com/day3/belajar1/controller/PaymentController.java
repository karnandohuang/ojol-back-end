package com.day3.belajar1.controller;

import com.day3.belajar1.model.Payment;
import com.day3.belajar1.service.PaymentService;
import com.day3.belajar1.webmodel.BaseResponse;
import com.day3.belajar1.webmodel.payment.PaymentListResponse;
import com.day3.belajar1.webmodel.payment.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/payments/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPaymentList(){
        List<Payment> paymentList;

        try {
            paymentList = paymentService.getPaymentList();

            PaymentListResponse paymentListResponse = new PaymentListResponse(paymentList);
            BaseResponse<PaymentListResponse> response =
                    new BaseResponse<>("OK", "200", paymentListResponse, "");

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            PaymentListResponse paymentListResponse = new PaymentListResponse(null);
            BaseResponse<PaymentListResponse> response =
                    new BaseResponse<>("Not Found", "404", paymentListResponse, "");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping(value = "/payments/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPayment(@RequestBody Payment request) {

        try {
            paymentService.savePayment(request);
            PaymentResponse paymentResponse = new PaymentResponse();
            BaseResponse<PaymentResponse> response = new BaseResponse<>("OK", "200", paymentResponse, "");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            PaymentResponse paymentResponse = new PaymentResponse();
            BaseResponse<PaymentResponse> response = new BaseResponse<>("Not Found", "404", paymentResponse, "");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
