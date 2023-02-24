package com.bridgelabz;

public class CabInvoice {
    private static final double MIN_COST_PER_KM = 10.0;
    private static final double MIN_FARE = 5;
    public final double COST_PER_TIME = 1.0;
    private static final double MIN_COST_PER_KM_PREMIUM = 15.0;
    private static final double MIN_FARE_PREMIUM = 20;
    public final double COST_PER_TIME_PREMIUM = 2.0;
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MIN_FARE);
    }

    public Invoice calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new Invoice(rides.length, totalFare);
    }

    public double calculateRideFare(String rideType, double distance, int time) {
        double totalFare, fare = 0;
        if (rideType.equalsIgnoreCase("normal")) {
            totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
            fare = Math.max(totalFare, MIN_FARE);
        }
        else if (rideType.equalsIgnoreCase("premium")) {
            totalFare = distance * MIN_COST_PER_KM_PREMIUM + time * COST_PER_TIME_PREMIUM;
            fare = Math.max(totalFare, MIN_FARE_PREMIUM);
        }
        return fare;
    }
}
