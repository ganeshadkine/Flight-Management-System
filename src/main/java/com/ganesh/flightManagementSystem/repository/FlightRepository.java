package com.ganesh.flightManagementSystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ganesh.flightManagementSystem.bean.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    boolean existsByCarrierNameAndFlightNumber(String carrierName, Long flightNumber);

    List<Flight> findByRouteId(Long routeId);

    List<Flight> findByDepartureAndArrival(String departure, String arrival);
    
    @Query("SELECT f FROM Flight f JOIN Route r ON f.routeId = r.routeId WHERE r.sourceAirport = :fromCity AND r.destinationAirport = :toCity")
    List<Flight> findByRoute(String fromCity, String toCity);
    
	Flight findByFlightNumber(Long flightNumber);
	Flight findFlightByFlightNumber(Long flightNumber);
     
}