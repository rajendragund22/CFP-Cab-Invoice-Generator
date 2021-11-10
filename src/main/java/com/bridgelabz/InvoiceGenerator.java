package com.bridgelabz;

/**
 * purpose- to perform cabInvoice generator and calculate the Fare
 *
 * @author Rajendra Gund
 * @version 1.0
 * @since 11/11/2021
 */
public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MINIMUM_FARE = 5;

    /**
     * method to calculate Total fare
     *
     * @param distance
     * @param time
     * @return total fare
     */
    public double calculateFare(double distance, int time) {
        double totalFare = 0;
        totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MIN;
        if (totalFare <= MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}

