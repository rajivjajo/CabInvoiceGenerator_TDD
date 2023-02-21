package com.bridgelabz;

public class Ride {
    private double distance;
    private double time ;
    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }
}
