package pradeepshah.SpringProject.demo.parkingLot;

public class Ticket {
    long entryTime;
    Vehicle vehicle;
    ParkingSpot spot;
    public Ticket(long entryTime, Vehicle vehicle, ParkingSpot spot){
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.spot = spot;
    }
}
