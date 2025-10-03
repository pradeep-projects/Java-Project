package pradeepshah.SpringProject.demo.parkingLot;

public class Vehicle {
    String vehicleNumber;
    String vehicleName;
    VehicleType vehicleType;
    public Vehicle(String vehicleName, String vehicleNumber, VehicleType vehicleType){
       this.vehicleName = vehicleName;
       this.vehicleNumber = vehicleNumber;
       this.vehicleType = vehicleType;
    }
}
