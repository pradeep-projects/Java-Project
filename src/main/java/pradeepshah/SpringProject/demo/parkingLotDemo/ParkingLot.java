package pradeepshah.SpringProject.demo.parkingLotDemo;
import java.util.*;
public class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingLevel> levels = new ArrayList<>();
    private final Map<String, Ticket> activeTickets = new HashMap<>();
    private final Object lock = new Object();

    private ParkingLot() {}

    public static synchronized ParkingLot getInstance(){
        if(instance == null) instance = new ParkingLot();
        return instance;
    }

    public void addLevel(ParkingLevel level){ levels.add(level); }

    public Ticket handleEntry(Vehicle v, ParkingStrategy strategy){
        synchronized(lock){
            for(ParkingLevel lvl : levels){
                ParkingSpot spot = lvl.findSpot(v.vehicleType, strategy);
                if(spot != null){
                    boolean parked = lvl.parkVehicle(spot, v);
                    if(parked){
                        Ticket t = TicketFactory.createTicket(v, spot);
                        activeTickets.put(t.ticketId, t);
                        System.out.println("Entry success: " + t);
                        return t;
                    }
                }
            }
            System.out.println("No spot available for " + v);
            return null;
        }
    }

    public boolean handleExit(String ticketId, PricingStrategy pricingStrategy, PaymentProcessor paymentProcessor){
        synchronized(lock){
            Ticket t = activeTickets.get(ticketId);
            if(t == null){
                System.out.println("Ticket not found or already exited: " + ticketId);
                return false;
            }
            t.markExit(System.currentTimeMillis());
            double amount = pricingStrategy.compute(t);
            boolean paid = paymentProcessor.pay(t, amount);
            if(paid){
                // free spot
                t.spot.removeVehicle();
                activeTickets.remove(ticketId);
                System.out.println("Exit success, paid " + amount + ". Ticket closed: " + t);
                return true;
            } else {
                System.out.println("Payment failed for " + ticketId);
                return false;
            }
        }
    }

    // utility for demo / status
    public void printStatus(){
        System.out.println("ParkingLot status:");
        for(ParkingLevel lvl : levels){
            System.out.println(" Level " + lvl.levelNumber + ":");
            for(ParkingSpot s : lvl.getSpots()) System.out.println("  " + s);
        }
    }
}
