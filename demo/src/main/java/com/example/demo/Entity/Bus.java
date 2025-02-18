package com.example.demo.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bus {

    @Id
    private int id;
    private String busNumber;
    private String route;
    private int capacity;
    private String driverName;



}
