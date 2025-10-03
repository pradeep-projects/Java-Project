package pradeepshah.SpringProject.demo.parkingLot;

public class ParkingSpot {
    int parkingSpotId;
    boolean isEmpty;
    Vehicle vehicle;
    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        isEmpty = false;
    }
    public void removeVehicle(){
        vehicle = null;
        isEmpty = true;
    }
}
