package com.ganesh.flightManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.flightManagementSystem.bean.FlightUser;

public interface UserRepository extends JpaRepository<FlightUser, Long> {
    FlightUser findByEmail(String email);
    FlightUser findByUsername(String username);

}