package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    CabInvoice cabInvoice = null;
    @BeforeEach
    public void setUp(){
        cabInvoice = new CabInvoice();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance = 3.0;
        int time = 5;
        double fare = cabInvoice.calculateFare(distance, time);
        Assertions.assertEquals(35, fare);
    }
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare(){
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoice.calculateFare(distance, time);
        Assertions.assertEquals(5, fare);
    }
    //    @Test
//    public void givenMultipleRides_ShouldReturnTotalFare(){
//        Ride[] rides = { new Ride(3.0, 5),
//                new Ride(0.1, 1) };
//        double fare = invoiceGenerator.calculateFare(rides);
//        Assertions.assertEquals(40, fare, 0.0);
//    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){
        Ride[] rides = { new Ride(3.0, 5),
                new Ride(0.1, 1) };
        Invoice summary = cabInvoice.calculateFare(rides);
        Invoice expectedInvoiceSummary = new Invoice(2, 40.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
    @Test
    public void givenUserId_ShouldReturnInvoiceSummary(){
        int userId = 1;
        Ride[] rides = { new Ride(3.0, 5),
                new Ride(0.1, 1) };
        Invoice summary = UserRideRepository.AddRide(userId, rides);
        Invoice expectedInvoiceSummary = new Invoice(2, 40.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
    @Test
    public void givenRideTypeNormal_ShouldReturnFare(){
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoice.calculateRideFare("NORMAL", distance, time);
        Assertions.assertEquals(5, fare);
    }
    @Test
    public void givenRideTypePremium_ShouldReturnFare(){
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoice.calculateRideFare("PREMIUM", distance, time);
        Assertions.assertEquals(20, fare);
    }
}