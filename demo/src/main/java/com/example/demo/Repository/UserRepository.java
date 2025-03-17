package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query("UPDATE User u SET u.username = :username, u.email = :email WHERE u.id = :id")
    void updateUser(@Param("id") int id, @Param("username") String username, @Param("email") String email);

    @Modifying
    @Query("DELETE FROM User u WHERE u.id = :id")
    void deleteUser(@Param("id") int id);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User getUserById(@Param("id") int id);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);
}
