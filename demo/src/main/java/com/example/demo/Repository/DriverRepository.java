package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer>{
           
}
