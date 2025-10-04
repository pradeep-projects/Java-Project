package pradeepshah.SpringProject.demo.parkingLotDemo;
import java.util.*;
public class ParkingLevel {
    final int levelNumber;
    final List<ParkingSpot> spots = new ArrayList<>();
    public ParkingLevel(int levelNumber){ this.levelNumber = levelNumber; }
    public void addSpot(ParkingSpot s){ spots.add(s); }
    public List<ParkingSpot> getSpots(){ return Collections.unmodifiableList(spots); }

    public synchronized ParkingSpot findSpot(VehicleType type, ParkingStrategy strategy){
        return strategy.find(type, this);
    }

    public synchronized boolean parkVehicle(ParkingSpot spot, Vehicle v){
        if(spot != null && spot.isEmpty()){
            spot.parkVehicle(v);
            return true;
        }
        return false;
    }
}
