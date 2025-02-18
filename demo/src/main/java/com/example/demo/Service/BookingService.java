package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Booking;
import com.example.demo.Repository.BookingRepository;

@Service
public class BookingService {
    
    @Autowired
    BookingRepository repo;

    public Booking saveBooking(Booking booking) {
        return repo.save(booking);
    }

}
