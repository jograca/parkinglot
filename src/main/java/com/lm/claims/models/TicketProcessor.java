package com.lm.claims.models;

public class TicketProcessor {

	private Receipt receipt = new Receipt();
	private TicketCalculator ticketCalculator;
	static double totalRevenue = 0;

	public double processTicket(Ticket ticket) {

		// calculate fee
		double result = ticketCalculator.calculateFee(ticket.getTimeIn(), receipt.getTimeOut());

		// pay
		if ("CreditCard".equals(receipt.getPaymentMethod())) {
			// && "processed".equals(ccs.processCard())) {

			result *= 0.975;
		}

		// generate receipt
		receipt = new Receipt(null, receipt.getTimeOut() - ticket.getTimeIn(), receipt.getTicketLost(), result);

		// reporting
		totalRevenue += result;
		System.out.println("Total Revenue: " + totalRevenue);

		return result;
	}

}
