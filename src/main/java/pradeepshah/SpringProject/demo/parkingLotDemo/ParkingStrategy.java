package pradeepshah.SpringProject.demo.parkingLotDemo;

public interface ParkingStrategy {
    public ParkingSpot find(VehicleType type, ParkingLevel level);
}
