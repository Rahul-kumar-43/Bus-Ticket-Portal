package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Booking;
import com.example.demo.Service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService service;

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return service.saveBooking(booking);
       
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return service.GetBooking();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
        Booking booking = service.GetBookingById(id);
        if (booking == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok().body(booking);
    }

    @PutMapping
    public void updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        service.updateBooking(id,booking.getBookingDate(), booking.getSeatId(),
                booking.getStatus(), booking.getPaymentStatus(), booking.getPickup(), booking.getDestination());
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {
        service.deleteBookingById(id);
    }

    @GetMapping("/pickup/{pickup}")
    public ResponseEntity<Booking> getBookingByPickup(@PathVariable String pickup) {
        Booking booking = service.getBookingByPickup(pickup);
        if (booking == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok().body(booking);
    }

    @GetMapping("/destination/{destination}")
    public ResponseEntity<Booking> getBookingByDestination(@PathVariable String destination) {
        Booking booking = service.getBookingByDestination(destination);
        if (booking == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok().body(booking);
    }

    @GetMapping("/sortBy/{field}")
    public List<Booking> sortBookings(@PathVariable String field) {
        return service.sort(field);
    }

    @GetMapping("/{offset}/{pagesize}")
    public List<Booking> pageBookings(@PathVariable int offset, @PathVariable int pagesize) {
        return service.page(pagesize, offset);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public List<Booking> pagesortBookings(@PathVariable int offset, @PathVariable int pagesize,
            @PathVariable String field) {
        return service.pagesort(pagesize, offset, field);
    }
}
