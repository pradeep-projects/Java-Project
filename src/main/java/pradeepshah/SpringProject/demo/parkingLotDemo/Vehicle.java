package pradeepshah.SpringProject.demo.parkingLotDemo;

public class Vehicle {
    final String vehicleNumber;
    final String vehicleName;
    final VehicleType vehicleType;
    public Vehicle(String vehicleName, String vehicleNumber, VehicleType vehicleType){
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
    @Override public String toString(){ return vehicleName + "(" + vehicleNumber + "," + vehicleType + ")"; }
}
