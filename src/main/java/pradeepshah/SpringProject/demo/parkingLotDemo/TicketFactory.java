package pradeepshah.SpringProject.demo.parkingLotDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketFactory {
    private static final AtomicInteger COUNTER = new AtomicInteger(1000);
    public static Ticket createTicket(Vehicle vehicle, ParkingSpot spot){
        String id = "T-" + COUNTER.getAndIncrement();
        return new Ticket(id, System.currentTimeMillis(), vehicle, spot);
    }
}
