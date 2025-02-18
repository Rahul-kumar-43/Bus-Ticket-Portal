package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Seat;
import com.example.demo.Repository.SeatRepository;

@ Service
public class SeatService {
    @Autowired
    SeatRepository repo;

    public List<Seat> listAll() {
        return repo.findAll();
    }
    public void save(Seat seat) {
        repo.save(seat);
    }
    public Seat get(int id) {
        return repo.findById(id).get();
    }
    public void delete(int id) {
        repo.deleteById(id);
    }
    public void update(Seat seat) {
        repo.save(seat);
    }
    

}
