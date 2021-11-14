package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {
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
    public void givenMultipleRides_ShouldReturnInvoiceSummery() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                        new Ride(0.1, 1)
        };
        InvoiceSummery summery = invoiceGenerator.calculateFare(rides);
        InvoiceSummery expectedInvoiceSummery = new InvoiceSummery(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummery, summery);
    }
    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() throws InvoiceGeneratorException {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        String[] userId = {"user1", "user2", "user3"};
        Ride[][] rides ={
                {new Ride(5.0, 12), new Ride(2.5, 6)},
                {new Ride(3.0, 5), new Ride(0.01, 1)},
                {new Ride(10.0, 15), new Ride(2, 30)} };
        invoiceGenerator.addRideToRepositoy(userId, rides);
        InvoiceSummery summery = invoiceGenerator.invoiceForUser(userId[2]);
        InvoiceSummery expectedInvoiceSummery = new InvoiceSummery(rides[2].length, 165.0);
        Assert.assertEquals(expectedInvoiceSummery, summery);
    }
}




