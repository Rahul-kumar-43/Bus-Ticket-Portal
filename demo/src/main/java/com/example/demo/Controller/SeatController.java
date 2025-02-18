package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Seat;
import com.example.demo.Service.SeatService;

@RestController
public class SeatController {

    @Autowired
    SeatService service;

    @PostMapping("/seat")
    public void Save( @RequestBody Seat seat) {
        service.save(seat);
    }

    @GetMapping("/seat/{id}")
    public Seat get(int id) {
        return service.get(id);
    }
    @GetMapping("/seat")
    public void listAll() {
        service.listAll();
    }
      
    @DeleteMapping("/seat/{id}")
    public void delete(int id) {
        service.delete(id);
    }
    @PutMapping("/seat/{id}")
    public void update(Seat seat) {
        service.update(seat);
    }



}
