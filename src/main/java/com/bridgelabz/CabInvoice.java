package com.bridgelabz;

public class CabInvoice {
    static final double COST_PER_KM = 10;
    static final double COST_PER_MIN = 1;

    public double calculateFare(double distance, double time) {
        double fare = COST_PER_KM * distance + COST_PER_MIN * time;
        return fare < 5 ? 5 : fare;
    }
    public double calculateFare(Ride[] rides) {
        double aggregateFare = 0 ;
        for (Ride ride:rides) {
            double totalFare = calculateFare(ride.getDistance(),ride.getTime());
            aggregateFare += totalFare;

        }
        return aggregateFare;
    }

    public Invoice generateInvoice(Ride[] rides) {
        int totalRide = rides.length;
        double totalFare = calculateFare(rides);
        double averageFare = totalFare/totalRide;
        return new Invoice(totalRide,totalFare,averageFare);
    }
}
