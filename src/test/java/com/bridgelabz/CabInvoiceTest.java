package com.bridgelabz;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CabInvoiceTest {
    @Test
    public void givenDistanceAndTimeShouldReturnFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.calculateFare(5.5, 3.5);
        assertEquals(58.5, fare, 0.0);
    }
    @Test
    public void givenDistanceAndTimeShouldReturnMinimumFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.calculateFare(0.4, 0.5);
        assertEquals(5, fare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnAggregateFare() {
        CabInvoice cabInvoice = new CabInvoice();
        Ride rides[] = {new Ride(0.4, 0.5), new Ride(5.5, 3.5), new Ride(2.5, 2.3)};
        double fare = cabInvoice.calculateFare(rides);

        assertEquals(90.8, fare, 0.0);
    }
    @Test
    public void givenMultipleRidesShouldReturnInvoice() {
        CabInvoice cabInvoice = new CabInvoice();
        Ride rides[] = {new Ride(0.4, 0.5), new Ride(5.5, 3.5), new Ride(2.5, 2.3)};
        Invoice actualInvoice = cabInvoice.generateInvoice(rides);
        Invoice expectedInvoice = new Invoice(3,90.8,90.8/3);
        assertEquals(expectedInvoice,actualInvoice);
    }
    @Test
    public void givenUserIdShouldReturnTheInvoice() {
        CabInvoice cabInvoice = new CabInvoice();
        String userId = "abc@123";
        Ride[] rides = {new Ride(2.0, 5), new Ride(0.1, 1)};
        cabInvoice.addRides(userId, rides);
        Invoice actual = cabInvoice.getInvoice(userId);
        Invoice expected = new Invoice(2, 30.0,15);
        assertEquals(actual, expected);
    }
}
