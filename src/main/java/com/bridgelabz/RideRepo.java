package com.bridgelabz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepo {
    Map<String, ArrayList<Ride>> userRides;

    public RideRepo() {
        userRides = new HashMap<String, ArrayList<Ride>>();
    }
    public void addRide(String userId, Ride[] ride) {
        ArrayList<Ride> ridesList = this.userRides.get(userId);
        if (ridesList == null) {
            this.userRides.put(userId, new ArrayList<Ride>(Arrays.asList(ride)));
        }
    }
    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}