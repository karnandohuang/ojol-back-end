package com.day3.belajar1.controller;

import com.day3.belajar1.model.Driver;
import com.day3.belajar1.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Driver> getDriverList(){
        List<Driver> driverList = null;
        try {
            driverList = driverService.getDriverList();
            return driverList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
