package com.ganesh.flightManagementSystem.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.flightManagementSystem.bean.Route;


@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

    @Query("SELECT MAX(r.routeId) FROM Route r")
    Long findMaxRouteId();

    @Query("SELECT r FROM Route r WHERE r.sourceAirport = ?1 AND r.destinationAirport = ?2")
    Optional<Route> findRouteByAirports(String sourceAirport, String destinationAirport);
    
    @Query("SELECT r.fare FROM Route r WHERE r.sourceAirport = :fromCity AND r.destinationAirport = :toCity")
    Double findFareByRoute(String fromCity, String toCity);
    
    Route findBySourceAirportAndDestinationAirport(String sourceAirport, String destinationAirport);
    
    @Query("SELECT r FROM Route r WHERE r.sourceAirport = :sourceAirport AND r.destinationAirport = :destinationAirport")
	Optional<Route> findBySourceAirportCodeAndDestinationAirportCode(String sourceAirport, String destinationAirport);
}