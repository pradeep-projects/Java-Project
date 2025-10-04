package pradeepshah.SpringProject.demo.parkingLotDemo;


/*
*  Simplified Parking Lot demo implementing:
 - Singleton ParkingLot
 - Strategy: ParkingStrategy, PricingStrategy
 - TicketFactory
 - ParkingLevel / ParkingSpot management
 *
 * UML Diagram:
 *
* */
public class ParkingDemoMain {
   public static void  main(String[] args) throws InterruptedException {
       ParkingLot lot = ParkingLot.getInstance();
       ParkingLevel L1 = new ParkingLevel(1);

       // adding parking spot on first floor
       L1.addSpot(new ParkingSpot(1,1, ParkingSpotType.MOTORBIKE));
       L1.addSpot(new ParkingSpot(2,1, ParkingSpotType.COMPACT));
       L1.addSpot(new ParkingSpot(3,1, ParkingSpotType.REGULAR));
       L1.addSpot(new ParkingSpot(4,1, ParkingSpotType.LARGE));
       lot.addLevel(L1);

       EntranceGate entrance = new EntranceGate(lot, new NearestToEntrance());
       ExitGate exitGate = new ExitGate(lot, new HourlyPriceStrategy(50.0), new PaymentProcessor());

       // Vehicles arrive
       Vehicle v1 = new Vehicle("Hero", "MH01AB1111", VehicleType.TWOWHEELER);
       Vehicle v2 = new Vehicle("Swift", "MH01AB2222", VehicleType.FOURWHEELER);

       Ticket t1 = entrance.processEntry(v1);
       Thread.sleep(1000); // simulate time
       Ticket t2 = entrance.processEntry(v2);

       lot.printStatus();

       // simulate parking time
       Thread.sleep(1500);

       // Exit v1
       if(t1 != null) exitGate.processExit(t1.ticketId);

       // Exit v2 after longer time
       Thread.sleep(2000);
       if(t2 != null) exitGate.processExit(t2.ticketId);

       lot.printStatus();
    }
}
