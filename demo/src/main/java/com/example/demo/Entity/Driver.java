package com.example.demo.Entity;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;
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
public class Driver {

    @Id

    private int id;
    private String name;
    private String licenseNumber;
    private long phone;

}