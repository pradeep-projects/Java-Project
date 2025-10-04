package pradeepshah.SpringProject.demo.parkingLotDemo;

public class EntranceGate {
    private final ParkingLot parkingLot;
    private final ParkingStrategy parkingStrategy;
    public EntranceGate(ParkingLot lot, ParkingStrategy strategy){
        this.parkingLot = lot; this.parkingStrategy = strategy;
    }
    public Ticket processEntry(Vehicle v){
        return parkingLot.handleEntry(v, parkingStrategy);
    }

}
