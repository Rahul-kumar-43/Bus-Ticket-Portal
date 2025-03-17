package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Booking;
import com.example.demo.Repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    BookingRepository repo;

    public void saveBooking(Booking booking) {
        repo.save(booking);
    }

    public List<Booking> GetBooking() {
        return repo.findAll();
    }

    public Booking GetBookingById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteBooking(int id) {
        repo.deleteById(id);
    }

    public Booking getBookingByPickup(String pickup) {
        return repo.getBookingByPickup(pickup);
    }

    public Booking getBookingByDestination(String destination) {
        return repo.getBookingByDestination(destination);
    }

    public void updateBooking(int id, String bookingDate, int SeatId, String status, String paymentStatus,
            String pickup, String destination) {
        repo.updateBooking(id, bookingDate, SeatId, status, paymentStatus, pickup, destination);
    }

    public void deleteBookingById(int id) {
        repo.deleteBooking(id);
    }

    public List<Booking> sort(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return repo.findAll(sort);
    }

    public List<Booking> page(int pageSize, int pageNumber) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return repo.findAll(page).getContent();
    }

    public List<Booking> pagesort(int pageSize, int pageNumber, String field) {
        return repo.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)))
                .getContent();
    }
}
