package com.lm.claims.models;

public class TicketCalculator {

	public double calculateFee(double timeIn, double timeOut, boolean ticketLost) {

		double result;

		// Scenario: Ticket is lost
		if (ticketLost) {
			result = 75;

		} else {

			// round time to nearest hour
			double hours = Math.round(timeOut - timeIn);

			double weeks = 0;
			double days = 0;

			// pull out whole weeks and days
			while (hours >= 24) {
				// Weeks checker
				if (hours >= 24 * 7) {
					weeks++;
					hours -= (24 * 7);
					// Day checker
				} else if (hours >= 24) {
					days++;
					hours -= 24;
				}
			}

			// set fees for whole units of time
			double dayFee = 15 * days;
			double hourFee = 2 * hours;
			double weekFee = 90 * weeks;

			// enforce that max daily fee is $15
			if (hourFee >= 15) {
				dayFee += 15;
				hourFee = 0;
			}

			// enforce that max weekly fee is $90
			if (dayFee >= 90) {
				weekFee += 90;
				dayFee = 0;
				hourFee = 0;
			}

			// add all fees
			result = weekFee + dayFee + hourFee;

		}
		return result;
	}
}
