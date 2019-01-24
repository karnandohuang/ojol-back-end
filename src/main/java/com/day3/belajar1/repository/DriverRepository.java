package com.day3.belajar1.repository;

import com.day3.belajar1.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {

    Driver findDriverById(int id);

}
