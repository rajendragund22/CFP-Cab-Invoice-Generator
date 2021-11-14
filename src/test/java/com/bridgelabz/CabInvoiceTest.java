package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {
    InvoiceServices invoiceService = new InvoiceServices();

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double minFare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5.0, minFare, 0.0);
    }

    @Test
    public void givenMultipleRide_ShouldReturnPremiumTotalFare() {
        Ride[] rides = {new Ride(2.0, 5, InvoiceServices.RideMode.PREMIUM),
                new Ride(0.1, 1, InvoiceServices.RideMode.PREMIUM),
        };
        InvoiceSummary summary = invoiceService.calculateFareForNormal(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 50);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnBothInvoiceSummary() throws InvoiceGeneratorException {
        String[] userId = {"user1", "user2", "user3"};
        Ride[][] rides = {
                {new Ride(5.0, 12, InvoiceServices.RideMode.NORMAL), new Ride(2.5, 6, InvoiceServices.RideMode.PREMIUM)},
                {new Ride(3.0, 5, InvoiceServices.RideMode.PREMIUM), new Ride(0.01, 1, InvoiceServices.RideMode.NORMAL)},
                {new Ride(10.0, 15, InvoiceServices.RideMode.NORMAL), new Ride(2, 30, InvoiceServices.RideMode.PREMIUM)}};
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 111.5);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}





