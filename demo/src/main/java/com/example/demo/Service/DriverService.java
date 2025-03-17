package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Driver;
import com.example.demo.Repository.DriverRepository;

@Service
public class DriverService {
    @Autowired
    DriverRepository repo;

    public void addDriver(Driver driver) {
        repo.save(driver);
    }

    public Iterable<Driver> getAllDrivers() {
        return repo.findAll();
    }

    public Driver getDriverById(long id) {
        return repo.findById(id).get();
    }

    public Driver getDriverByLicenseNumber(String licenseNumber) {
        return repo.getDriverByLicenseNumber(licenseNumber);
    }
    public Driver getDriverByPhone(long phone) {
        return repo.getDriverByPhone(phone);
    }
    public void UpdateDriver(Driver driver) {
        repo.save(driver);
    }
    public Driver getDriverByName(String name) {
        return repo.getDriverByName(name);
    }

    public void deleteDriver(long id) {
        repo.deleteById(id);
    }
    public void deleteAllDrivers() {
        repo.deleteAll();
    }
    public List<Driver> sortDrivers(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return repo.findAll(sort);
    }
    public List<Driver> page(int pageSize, int pageNumber) {
        PageRequest page = PageRequest.of(pageNumber, pageSize);
        return repo.findAll(page).getContent();
    }
    
    public List<Driver> pagesort(int pageSize, int pageNumber, String field) {
        return repo.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)))
                .getContent();
    }
    
}