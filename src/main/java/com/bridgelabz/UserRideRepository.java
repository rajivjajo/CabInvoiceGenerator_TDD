package com.bridgelabz;

import java.util.HashMap;

public class UserRideRepository {
    public static HashMap<Integer, Ride[]> UserAccount =  new HashMap<>();
    public static Invoice AddRide(int userId, Ride[] rides) throws IllegalArgumentException {
        CabInvoice invoiceGenerator = new CabInvoice();
        try {
            if (userId <= 0) {
                throw new IllegalArgumentException();
            }
            if (rides.length <= 0) {
                throw new IllegalArgumentException();
            }
            if (UserAccount.containsKey(userId)) {
                UserAccount.put(userId, rides);
            }
            Invoice summary = invoiceGenerator.calculateFare(rides);
            return summary;
        }catch (Exception e)
        {
            System.out.println("Error: "+e);
            e.printStackTrace();
        }
        return null;
    }
}