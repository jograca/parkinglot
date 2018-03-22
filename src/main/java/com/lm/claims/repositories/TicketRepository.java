package com.lm.claims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lm.claims.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	Ticket findById(int id);

}
