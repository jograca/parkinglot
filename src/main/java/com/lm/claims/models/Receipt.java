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
	private double totalTimeParked;

	@Column(nullable = false)
	private double timeOut;

	private double feeCollected;

	private String paymentMethod;

	public Receipt() {

	}

	public Receipt(double totalTimeParked, double feeCollected) {
		this.totalTimeParked = totalTimeParked;
		this.feeCollected = feeCollected;
	}

	public double getTotalTimeParked() {
		return totalTimeParked;
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

	public void setTotalTimeParked(double totalTimeParked) {
		this.totalTimeParked = totalTimeParked;
	}

	public void setFeeCollected(double feeCollected) {
		this.feeCollected = feeCollected;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public double getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(double timeOut) {
		this.timeOut = timeOut;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}