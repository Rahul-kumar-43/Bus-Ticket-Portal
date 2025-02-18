package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Driver;
import com.example.demo.Repository.DriverRepository;

@Service
public class DriverService {
    @Autowired
    DriverRepository repo;

    public void addDriver(Driver driver) {
        repo.save(driver);
    }

    public Iterable<Driver> getAllDrivers() {
        return repo.findAll();
    }

    public Driver getDriverById(int id) {
        return repo.findById(id).get();
    }
    public void UpdateDriver(Driver driver) {
        repo.save(driver);
    }

    public void deleteDriver(int id) {
        repo.deleteById(id);
    }
    
}