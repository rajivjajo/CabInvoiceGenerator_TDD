package com.bridgelabz;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {
    @Test
    public void givenDistanceAndTimeShouldReturnFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.calculateFare(5.5, 3.5);
        Assert.assertEquals(58.5, fare, 0.0);
    }
    @Test
    public void givenDistanceAndTimeShouldReturnMinimumFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.calculateFare(0.4, 0.5);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRidesShouldReturnAggregateFare() {
        CabInvoice cabInvoice = new CabInvoice();
        Ride rides[] = {new Ride(0.4, 0.5), new Ride(5.5, 3.5), new Ride(2.5, 2.3)};
        double fare = cabInvoice.calculateFare(rides);

        Assert.assertEquals(90.8, fare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnInvoice() {
        CabInvoice cabInvoice = new CabInvoice();
        Ride rides[] = {new Ride(0.4, 0.5), new Ride(5.5, 3.5), new Ride(2.5, 2.3)};
        Invoice actualInvoice = cabInvoice.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(3,90.8,90.8/3);
        Assert.assertEquals(expectedInvoice,actualInvoice);
    }
}
