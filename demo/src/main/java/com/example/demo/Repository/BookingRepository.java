package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Modifying
    @Query("UPDATE Booking b SET  b.bookingDate = :bookingDate, b.SeatId = :SeatId, b.status = :status, b.paymentStatus = :paymentStatus, b.pickup = :pickup, b.destination = :destination WHERE b.id = :id")
    void updateBooking(@Param("id") int id, @Param("bookingDate") String bookingDate,
            @Param("SeatId") int SeatId, @Param("status") String status, @Param("paymentStatus") String paymentStatus,
            @Param("pickup") String pickup, @Param("destination") String destination);

    @Modifying
    @Query("DELETE FROM Booking b WHERE b.id = :id")
    void deleteBooking(@Param("id") int id);

    @Query("SELECT b FROM Booking b WHERE b.destination = :destination")
    Booking getBookingByDestination(@Param("destination") String destination);

    @Query("SELECT b FROM Booking b WHERE b.pickup = :pickup")
    Booking getBookingByPickup(@Param("pickup") String pickup);
}
