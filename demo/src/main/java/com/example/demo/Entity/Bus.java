package com.example.demo.Entity;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String busNumber;
    private String route;
    private int capacity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    @JsonBackReference
    private Driver driver;
    public void setDriver(Driver driver) {
        driver.setBus(this);
        this.driver = driver; 
    }
}