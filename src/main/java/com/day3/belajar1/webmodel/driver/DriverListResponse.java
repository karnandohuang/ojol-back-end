package com.day3.belajar1.webmodel.driver;

import com.day3.belajar1.model.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DriverListResponse {

    List<Driver> data;

}
