package com.day3.belajar1.service;

import com.day3.belajar1.model.Driver;
import com.day3.belajar1.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public List<Driver> getDriverList() throws Exception{
        return driverRepository.findAll();
    }

}
