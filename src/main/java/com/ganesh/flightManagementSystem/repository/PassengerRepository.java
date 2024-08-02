package com.ganesh.flightManagementSystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.flightManagementSystem.bean.Passenger;
import com.ganesh.flightManagementSystem.bean.TicketPassengerEmbed;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, TicketPassengerEmbed> {
	List<Passenger> findByEmbeddedIdTicketNumber(Long ticketNumber);
	
	
	List<Passenger> findByEmbeddedId_TicketNumberOrderByEmbeddedId_SerialNumber(Long ticketNumber);
    List<Passenger> findAllByOrderByEmbeddedId_TicketNumberAsc();
}