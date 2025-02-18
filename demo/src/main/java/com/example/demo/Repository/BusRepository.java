package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer> {

}
