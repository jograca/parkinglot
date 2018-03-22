package com.lm.claims.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lm.claims.models.Ticket;
import com.lm.claims.repositories.TicketRepository;

@RestController
@RequestMapping("/api/tickets")
public class TicketApiController {

	private TicketRepository ticketRepo;

	public TicketApiController(TicketRepository ticketRepo) {
		this.ticketRepo = ticketRepo;
	}

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Ticket> getAll() {
		List<Ticket> tickets = ticketRepo.findAll();
		return tickets;
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Ticket getOne(@PathVariable int id) {
		Ticket ticket = ticketRepo.findById(id);
		return ticket;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ticket create(@RequestBody Ticket ticket) {
		return ticketRepo.save(ticket);
	}

}
