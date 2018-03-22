package com.lm.claims.models;

public class TicketProcessor {

	private Receipt receipt;
	private TicketCalculator ticketCalculator;
	static double totalRevenue = 0;

	public TicketProcessor(TicketCalculator ticketCalculator) {
		this.ticketCalculator = ticketCalculator;
	}

	public Receipt processTicket(Ticket ticket) {

		// calculate fee
		double result = ticketCalculator.calculateFee(ticket.getTimeIn(), receipt.getTimeOut(), ticket.isTicketLost());

		// pay
		if ("CreditCard".equals(receipt.getPaymentMethod())) {
			// && "processed".equals(ccs.processCard())) {

			result *= 0.975;
		}

		// generate receipt
		receipt = new Receipt((receipt.getTimeOut() - ticket.getTimeIn()), result);

		// reporting
		totalRevenue += result;
		System.out.println("Total Revenue: " + totalRevenue);

		return receipt;
	}

}
