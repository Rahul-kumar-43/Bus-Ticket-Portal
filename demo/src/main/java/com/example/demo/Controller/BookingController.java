package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Booking;
import com.example.demo.Service.BookingService;

@RestController
public class BookingController {
    @Autowired
    BookingService service;

    @PostMapping("/booking")
    public Booking saveBooking(Booking booking) {
        return service.saveBooking(booking);
    }
    


}
