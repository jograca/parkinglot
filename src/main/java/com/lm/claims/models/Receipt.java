package com.lm.claims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Receipt {

	@Id
	@GeneratedValue(generator = "receipt_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "receipt_id_seq", sequenceName = "receipt_id_seq")
	private int id;

	@OneToOne
	private Ticket ticket;

	@Column(nullable = false)
	private String carId;

	@Column(nullable = false)
	private double totalTimeParked;

	private String ticketLost;

	private double feeCollected;

	public Receipt() {

	}

	public Receipt(String carId, double totalTimeParked, String ticketLost, double feeCollected) {
		this.carId = carId;
		this.totalTimeParked = totalTimeParked;
		this.ticketLost = ticketLost;
		this.feeCollected = feeCollected;
	}

	public String getCarId() {
		return carId;
	}

	public double getTotalTimeParked() {
		return totalTimeParked;
	}

	public String getTicketLost() {
		return ticketLost;
	}

	public double getFeeCollected() {
		return feeCollected;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public void setTotalTimeParked(double totalTimeParked) {
		this.totalTimeParked = totalTimeParked;
	}

	public void setTicketLost(String ticketLost) {
		this.ticketLost = ticketLost;
	}

	public void setFeeCollected(double feeCollected) {
		this.feeCollected = feeCollected;
	}

}