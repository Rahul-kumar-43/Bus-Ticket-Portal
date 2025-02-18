package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bus;
import com.example.demo.Repository.BusRepository;

@Service
public class BusService {

    @Autowired
    private BusRepository repo;

    public Bus getBusById(int id) {
        return repo.findById(id).get();
    }

    public List<Bus> getAllBuses() {
        return repo.findAll();
    }

    public void addBus(Bus bus) {
        repo.save(bus);
    }

    public void deleteAllBuses() {
        repo.deleteAll();
    }

    public void deleteBusById(int id) {
        repo.deleteById(id);
    }

    public List<Bus> getSortedBuses(String sortBy) {
        return repo.findAll(); 
    }
}
