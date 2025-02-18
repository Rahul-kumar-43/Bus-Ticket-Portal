package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Seat {

    @Id
    private int id;
    
    private String seatType;
    private boolean Isavailable;
    private int seatNumber;
    private int seatPrice;
}
