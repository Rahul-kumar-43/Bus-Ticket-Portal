package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import com.example.demo.Entity.Bus;
@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    @Modifying
    @Query("UPDATE Bus b SET b.busNumber = :busNumber, b.route = :route, b.capacity = :capacity WHERE b.id = :id")
    void updateBus(@Param("id") int id, @Param("busNumber") String busNumber, @Param("route") String route,
            @Param("capacity") int capacity);
    @Modifying
    @Query("DELETE FROM Bus b WHERE b.id = :id")
    void deleteBus(@Param("id") int id);
    @Query("SELECT b FROM Bus b WHERE b.route = :route")
    Bus getBusByRoute(@Param("route") String route);
}
