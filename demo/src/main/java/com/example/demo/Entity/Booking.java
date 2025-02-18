package com.example.demo.Entity;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
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
    private int id;
    private int userId;
    private String bookingDate;
    private int SeatId;
    private String status;
    private String paymentStatus;
    private String pickup;
    private String destination;

}
