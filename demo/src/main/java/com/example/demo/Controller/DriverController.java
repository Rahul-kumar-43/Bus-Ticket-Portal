package com.example.demo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.Driver;
import com.example.demo.Service.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@RestController
@RequestMapping("/api/drivers")
@Validated
public class DriverController {
    @Autowired
    DriverService service;
    @PostMapping
    public ResponseEntity<Driver> addDriver( @RequestBody Driver driver) {
        service.addDriver(driver);
        return ResponseEntity.ok(driver);
    }
    @GetMapping
    public Iterable<Driver> getAllDrivers() {
        return service.getAllDrivers();
    }
    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable int id) {
        return service.getDriverById(id);
    }
    @DeleteMapping
    public void deleteAllDrivers() {
        service.deleteAllDrivers();
    }
    @PutMapping("/{id}")
    public void updateDriver(@PathVariable int id, @RequestBody Driver driver) {
        service.UpdateDriver(driver);
    }
    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable int id) {
        service.deleteDriver(id);
    }
    @GetMapping("/sortBy/{field}")
    public List<Driver> sortDrivers(@PathVariable String field) {
        return service.sortDrivers(field);
    }
    @GetMapping("/license/{licenseNumber}")
    public ResponseEntity<Driver> getDriverByLicenseNumber(@PathVariable String licenseNumber) {
        Driver driver = service.getDriverByLicenseNumber(licenseNumber);
        if (driver == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok().body(driver);
    }
    @GetMapping("/phone/{phone}")
    public ResponseEntity<Driver> getDriverByPhone(@PathVariable long phone) {
        Driver driver = service.getDriverByPhone(phone);
        if (driver == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok().body(driver);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Driver> getDriverByName(@PathVariable String name) {
        Driver driver = service.getDriverByName(name);
        if (driver == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok().body(driver);
    }
    @GetMapping("/{offset}/{pagesize}")
    public List<Driver> page(@PathVariable int offset, @PathVariable int pagesize) {
        return service.page(pagesize, offset);
    }
    @GetMapping("/{offset}/{pagesize}/{field}")
    public List<Driver> pagesort(@PathVariable int offset, @PathVariable int pagesize, @PathVariable String field) {
        return service.pagesort(pagesize, offset, field);
    }
}
