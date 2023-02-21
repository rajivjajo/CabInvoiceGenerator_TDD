package com.bridgelabz;
import java.util.Objects;

public class Invoice {
    private int totalRide;
    private double totalFare;
    private double averageFare;

    public Invoice(int totalRide, double totalFare, double averageFare) {
        this.totalRide = totalRide;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    public int getTotalRide() {
        return totalRide;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalRide == invoice.totalRide && Double.compare(invoice.totalFare, totalFare) == 0 && Double.compare(invoice.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRide, totalFare, averageFare);
    }
}
