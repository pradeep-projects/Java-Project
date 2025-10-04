package pradeepshah.SpringProject.demo.parkingLotDemo;

public class ParkingSpot {
    final int id;
    final int level;
    final ParkingSpotType type;
    private boolean isEmpty = true;
    private Vehicle vehicle;
    public ParkingSpot(int id, int level, ParkingSpotType type){
        this.id = id; this.level = level; this.type = type;
    }
    public synchronized boolean isEmpty(){ return isEmpty; }
    public synchronized void parkVehicle(Vehicle v){
        this.vehicle = v; this.isEmpty = false;
    }
    public synchronized void removeVehicle(){
        this.vehicle = null; this.isEmpty = true;
    }
    public int getId(){ return id; }
    public String getKey(){ return "L"+level+"-S"+id; }
    @Override public String toString(){ return "Spot{" + getKey() + "," + type + "," + (isEmpty? "EMPTY":"OCC") + "}"; }
}
