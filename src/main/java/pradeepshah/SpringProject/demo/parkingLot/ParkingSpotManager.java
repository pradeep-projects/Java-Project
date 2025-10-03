package pradeepshah.SpringProject.demo.parkingLot;

import java.util.*;
public class ParkingSpotManager {
    // 1 to many relation with parking spot
    List<ParkingSpot> psList;
    public  ParkingSpotManager(List<ParkingSpot> list){
        this.psList = list;
    }
    public ParkingSpot findParkingSpace(){
        return new ParkingSpot();
    }
    public void removeParkingSpace(){

    }

    public  void parkVehicle(){

    }

}
