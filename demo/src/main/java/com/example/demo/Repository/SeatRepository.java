package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
