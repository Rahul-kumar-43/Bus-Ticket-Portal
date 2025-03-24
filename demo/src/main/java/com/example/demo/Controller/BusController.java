package com.example.demo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.Entity.Bus;
import com.example.demo.Service.BusService;
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
    @GetMapping("/{field}")
    public List<Bus> sortBuses(@PathVariable String field) {
        return service.sort(field);
    }
    @DeleteMapping("/{id}")
    public void deleteBusById(@PathVariable int id) {
        service.deleteBusById(id);
    }
    @DeleteMapping
    public void deleteAllBuses() {
        service.deleteAllBuses();
    }
    @PutMapping
    public void updateBus(@RequestBody Bus bus) {
        service.updateBus(bus);
    }
    @GetMapping("/route/{route}")
    public ResponseEntity<Bus> getBusByRoute(@PathVariable String route) {
       Bus bus = service.getBusByRoute(route);
        if(bus == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok().body(bus);
    }
    @GetMapping("/{offset}/{pagesize}")
    public List<Bus> page(@PathVariable int offset, @PathVariable int pagesize) {
        return service.page(pagesize, offset);
    }
    @GetMapping("/{offset}/{pagesize}/{field}")
    public List<Bus> pagesort(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field) {
        return service.pagesort(pagesize, offset, field);
    }
}
