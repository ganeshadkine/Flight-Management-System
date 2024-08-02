package com.ganesh.flightManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ganesh.flightManagementSystem.bean.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
    @Query("SELECT MAX(t.ticketNumber) FROM Ticket t")
    Long findMaxTicketNumber();
}