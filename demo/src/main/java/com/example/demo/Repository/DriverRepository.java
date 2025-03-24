package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import com.example.demo.Entity.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Modifying
    @Query("UPDATE Driver d SET d.name = :name, d.licenseNumber = :licenseNumber, d.phone = :phone WHERE d.id = :id")
    void updateDriver(@Param("id") int id, @Param("name") String name, @Param("licenseNumber") String licenseNumber,
            @Param("phone") long phone);
    @Modifying
    @Query("DELETE FROM Driver d WHERE d.id = :id")
    void deleteDriver(@Param("id") int id);
    @Query("SELECT d FROM Driver d WHERE d.licenseNumber = :licenseNumber")
    Driver getDriverByLicenseNumber(@Param("licenseNumber") String licenseNumber);
    @Query("SELECT d FROM Driver d WHERE d.phone = :phone")
    Driver getDriverByPhone(@Param("phone") long phone);
    @Query("SELECT d FROM Driver d WHERE d.name = :name")
    Driver getDriverByName(@Param("name") String name);
}
