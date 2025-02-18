package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Bus;
import com.example.demo.Service.BusService;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    BusService service;

    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        service.addBus(bus);
        return bus;
    }

    @GetMapping
    public Iterable<Bus> getAllBuses() {
        return service.getAllBuses();
    }

    @GetMapping("/sorted")
    public List<Bus> getSortedBuses(@RequestParam String sortBy) {
        return service.getSortedBuses(sortBy);
    }

    @DeleteMapping("/{id}")
    public void deleteBusById(@PathVariable int id) {
        service.deleteBusById(id);
    }
}
