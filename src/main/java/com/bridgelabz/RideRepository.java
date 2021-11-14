package com.bridgelabz;


import java.util.*;

public class RideRepository {
    Map<String, Ride[]> userRides;

    public RideRepository() {

        this.userRides = new HashMap<>();
    }
    public Ride[] getRidesForUser(String userId) {
        return userRides.get(userId);
    }

    public void addRideForUser(String userId, Ride[] ride) throws InvoiceGeneratorException {
        if (userRides.containsKey(userId))
            throw new InvoiceGeneratorException(InvoiceGeneratorException.ExceptionType.USER_ALREADY_EXISTS,
                    "User ID Already Exists!!!");
        userRides.put(userId, ride);
    }


    public void addRides(String userId, Ride[] rides) throws InvoiceGeneratorException {
        if (userRides.containsKey(userId))
            throw new InvoiceGeneratorException(InvoiceGeneratorException.ExceptionType.USER_ALREADY_EXISTS,
                    "User ID Already Exists!!!");
        else
            userRides.put(userId, rides);
    }

    public Ride[] getRides(String[] userId) {
        return this.userRides.get(userId[0]);


    }
}