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
public class Admin {

    @Id
    private int id;
    private String name;
    private String email;
    private String password;


}
