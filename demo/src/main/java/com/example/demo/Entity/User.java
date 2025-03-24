package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Booking> bookings = new ArrayList<>();
    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBooking(List<Booking> book) {
        for (Booking add : book) {
            add.setUser(this);
        }
        this.bookings.addAll(book);
    }

    public void addBooking(Booking booking) {
        booking.setUser(this);
        this.bookings.add(booking);
    }
}
