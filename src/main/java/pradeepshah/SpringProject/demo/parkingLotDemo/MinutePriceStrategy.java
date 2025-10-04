package pradeepshah.SpringProject.demo.parkingLotDemo;

import java.time.Duration;

public class MinutePriceStrategy implements PricingStrategy{
    private final double perMinute;
    public MinutePriceStrategy(double perMinute){ this.perMinute = perMinute; }
    @Override
    public double compute(Ticket ticket) {
        Duration d = ticket.getDuration();
        long minutes = Math.max(1, d.toMinutes());
        return minutes * perMinute;
    }
}