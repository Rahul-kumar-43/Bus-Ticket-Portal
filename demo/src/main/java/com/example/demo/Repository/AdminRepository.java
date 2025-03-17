package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Modifying
    @Query("UPDATE Admin a SET a.name = :name, a.email = :email WHERE a.id = :id")
    void updateAdmin(@Param("id") int id, @Param("name") String name, @Param("email") String email);

    @Modifying
    @Query("DELETE FROM Admin a WHERE a.id = :id")
    void deleteAdmin(@Param("id") int id);

    @Query("SELECT a FROM Admin a WHERE a.id = :id")
    Admin getAdminById(@Param("id") int id);

    @Query("SELECT a FROM Admin a WHERE a.name = :name")
    Admin getAdminByName(@Param("name") String name);

    @Query("SELECT a FROM Admin a WHERE a.email = :email")
    Admin getAdminByEmail(@Param("email") String email);
}
