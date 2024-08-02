package com.ganesh.flightManagementSystem.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ganesh.flightManagementSystem.bean.Airport;

public interface AirportRepository extends JpaRepository<Airport, String> {
	
    Optional<Airport> findByAirportLocation(String airportLocation);

@Query("SELECT a.airportLocation FROM Airport a")
List<String> findAllAirportLocations();

@Query("SELECT a.airportCode FROM Airport a WHERE a.airportLocation = :location")
String findAirportCodeByLocation(String location);

}
