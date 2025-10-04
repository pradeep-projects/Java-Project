package pradeepshah.SpringProject.demo.parkingLotDemo;

public class NearestToEntrance implements ParkingStrategy{
    @Override
    public ParkingSpot find(VehicleType type, ParkingLevel level) {
        // simple: iterate and pick first empty suitable spot
        for(ParkingSpot s : level.getSpots()){
            if(s.isEmpty()){
                // simple suitability rules
                if(type == VehicleType.TWOWHEELER && (s.type == ParkingSpotType.MOTORBIKE || s.type==ParkingSpotType.COMPACT)) return s;
                if(type == VehicleType.FOURWHEELER && (s.type == ParkingSpotType.COMPACT || s.type==ParkingSpotType.REGULAR || s.type==ParkingSpotType.LARGE)) return s;
            }
        }
        return null;
    }
}
