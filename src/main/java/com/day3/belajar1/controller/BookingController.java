package com.day3.belajar1.controller;

import com.day3.belajar1.model.Account;
import com.day3.belajar1.model.Booking;
import com.day3.belajar1.model.Driver;
import com.day3.belajar1.model.Payment;
import com.day3.belajar1.service.AccountService;
import com.day3.belajar1.service.BookingService;
import com.day3.belajar1.service.DriverService;
import com.day3.belajar1.service.PaymentService;
import com.day3.belajar1.webmodel.BaseResponse;
import com.day3.belajar1.webmodel.booking.BookingListResponse;
import com.day3.belajar1.webmodel.booking.BookingResponse;
import com.day3.belajar1.webmodel.request.booking.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    AccountService accountService;

    @Autowired
    DriverService driverService;

    @GetMapping(value = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBookingList() {
        List<Booking> bookingList = null;

        try {
            bookingList = bookingService.getBookingList();

            BookingListResponse bookingListResponse = new BookingListResponse(bookingList);
            BaseResponse<BookingListResponse> response = new BaseResponse<>("OK", "200", bookingListResponse, "");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            BaseResponse<BookingListResponse> response = new BaseResponse<>("Fail", "404", null, "");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping(value = "/bookings/history/{accountId}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBookingListHistory(@PathVariable("accountId") int accountId,@PathVariable("status") String status){
        List<Booking> bookingList = null;

        try {
            bookingList = bookingService.getBookingListHistory(accountId, status);

            BookingListResponse bookingListResponse = new BookingListResponse(bookingList);
            BaseResponse<BookingListResponse> response = new BaseResponse<>("OK", "200", bookingListResponse, "");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            BaseResponse<BookingListResponse> response = new BaseResponse<>("Fail", "404", null, "");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping(value = "/bookings/_schedule", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveBooking(@RequestBody BookingRequest request){
        try {

            Payment payment = paymentService.getPayment(request.getId());
            Account account = accountService.getAccount(request.getAccountId());
            Driver driver = driverService.getDriver(request.getDriverId());

            Booking booking = new Booking();
            booking.setId(request.getId());
            booking.setStatus(request.getStatus());
            booking.setPrice(request.getPrice());
            booking.setPayment(payment);
            booking.setAccount(account);
            booking.setDriver(driver);

            bookingService.saveBooking(booking);

            BaseResponse<BookingResponse> response =
                    new BaseResponse<>("OK", "200", null, "Booking Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();

            BaseResponse<BookingResponse> response =
                    new BaseResponse<>("Fail", "404", null, "Booking Failed");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @DeleteMapping(value = "/bookings/{id}/cancel", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cancelBooking(@PathVariable("id") int id){

        try {
            bookingService.deleteBooking(id);

            BaseResponse<BookingResponse> response = new BaseResponse<>("OK", "200", null, "");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e){
            e.printStackTrace();

            BaseResponse<BookingResponse> response = new BaseResponse<>("Fail", "404", null, "");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
