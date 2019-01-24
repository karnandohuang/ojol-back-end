package com.day3.belajar1.controller;

import com.day3.belajar1.model.Driver;
import com.day3.belajar1.service.DriverService;
import com.day3.belajar1.webmodel.BaseResponse;
import com.day3.belajar1.webmodel.driver.DriverListResponse;
import com.day3.belajar1.webmodel.driver.DriverResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDriverList() {
        List<Driver> driverList = null;
        try {
            driverList = driverService.getDriverList();

            DriverListResponse driverListResponse = new DriverListResponse(driverList);
            BaseResponse<DriverListResponse> response = new BaseResponse<>("OK", "200", driverListResponse, "");

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            BaseResponse<DriverListResponse> response = new BaseResponse<>("Fail", "404", null, "");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    @GetMapping(value = "/drivers/GOJ-{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDriver(@PathVariable("id") int id){

        try {
            Driver driver = driverService.getDriver(id);
            DriverResponse driverResponse = new DriverResponse(driver);
            BaseResponse<DriverResponse> response = new BaseResponse<>("OK", "200", driverResponse, "");
            return ResponseEntity.status(HttpStatus.OK).body(response);

        }catch (Exception e){
            BaseResponse<DriverResponse> response = new BaseResponse<>("Fail", "404", null, "");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping(value = "/drivers/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addDriver(@RequestBody Driver request){
        try {
            driverService.saveDriver(request);

            BaseResponse<DriverResponse> response =
                    new BaseResponse<>("OK", "200", null, "Add driver success");

            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e){
            e.printStackTrace();
            BaseResponse<DriverResponse> response =
                    new BaseResponse<>("Fail", "404", null, "Add driver failed");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
