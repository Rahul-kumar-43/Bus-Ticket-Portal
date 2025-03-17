package com.example.demo.Entity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
// import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookingDate;
    private int SeatId;
    private String status;
    private String paymentStatus;
    private String pickup;
    private String destination;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    

}
