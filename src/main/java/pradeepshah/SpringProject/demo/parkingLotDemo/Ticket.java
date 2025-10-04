package pradeepshah.SpringProject.demo.parkingLotDemo;

import java.time.Duration;
import java.time.Instant;

public class Ticket {
    final String ticketId;
    final long entryTimeMillis;
    Long exitTimeMillis; // null until exit
    final Vehicle vehicle;
    final ParkingSpot spot;
    double amount;
    boolean paid;
    public Ticket(String ticketId, long entryTimeMillis, Vehicle vehicle, ParkingSpot spot){
        this.ticketId = ticketId;
        this.entryTimeMillis = entryTimeMillis;
        this.vehicle = vehicle;
        this.spot = spot;
        this.paid = false;
    }
    public void markExit(long exitMillis){
        this.exitTimeMillis = exitMillis;
    }
    public Duration getDuration(){
        long exit = exitTimeMillis == null ? System.currentTimeMillis() : exitTimeMillis;
        return Duration.ofMillis(exit - entryTimeMillis);
    }
    @Override public String toString(){
        return "Ticket{" + ticketId + ", veh=" + vehicle + ", spot=" + spot.getKey() + ", entry=" + Instant.ofEpochMilli(entryTimeMillis)
                + (exitTimeMillis==null? "": ", exit="+ Instant.ofEpochMilli(exitTimeMillis)) + ", amt=" + amount + ", paid=" + paid + "}";
    }
}
