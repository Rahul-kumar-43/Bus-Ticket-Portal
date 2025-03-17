package com.example.demo.Entity;

// import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Booking> bookings = new ArrayList<>();
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> book) {
        for (Booking booking : book) {
            booking.setUser(this);
        }
        this.bookings.addAll(book);
    }

    public void addBooking(Booking booking) {
        booking.setUser(this);
        this.bookings.add(booking);
    }
}
