package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Driver;
import com.example.demo.Service.DriverService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    DriverService service;

    @PostMapping
    public Driver addDriver(@RequestBody Driver driver) {
        service.addDriver(driver);
        return driver;
    }

    @GetMapping
    public Iterable<Driver> getAllDrivers() {
        return service.getAllDrivers();
    }

    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable int id) {
        return service.getDriverById(id);
    }

    @PutMapping("/{id}")
    public void getDriverById(@PathVariable int id, @RequestBody Driver driver) {
        service.UpdateDriver(driver);
    }
    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable int id) {
        service.deleteDriver(id);
    }
  
    
}
