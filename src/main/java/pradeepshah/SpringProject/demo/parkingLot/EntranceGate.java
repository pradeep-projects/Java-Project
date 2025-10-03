package pradeepshah.SpringProject.demo.parkingLot;

public class EntranceGate {
    ParkingSpotManager psmObj;
    public ParkingSpot findSpace(VehicleType type){
        return new ParkingSpot();
    }
    public Ticket generateTicket(){
        return new Ticket(322,new Vehicle("volvo","43943",VehicleType.FOURWHEELER),new ParkingSpot());
    }


}
