package com.lm.claims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(generator = "ticket_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "ticket_id_seq", sequenceName = "ticket_id_seq")
	private int id;

	@OneToOne
	private Receipt receipt;

	@Column(nullable = false)
	private double timeIn;

	public Ticket() {

	}

	public Ticket(double timeIn) {
		this.timeIn = timeIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(double timeIn) {
		this.timeIn = timeIn;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

}