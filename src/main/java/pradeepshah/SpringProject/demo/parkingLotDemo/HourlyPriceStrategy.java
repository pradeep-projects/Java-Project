package pradeepshah.SpringProject.demo.parkingLotDemo;

import java.time.Duration;

public class HourlyPriceStrategy implements PricingStrategy{
    private final double hourlyRate;
    public HourlyPriceStrategy(double hourlyRate){ this.hourlyRate = hourlyRate; }
    @Override
    public double compute(Ticket ticket) {
        Duration d = ticket.getDuration();
        long minutes = d.toMinutes();
        long hours = Math.max(1, (int)Math.ceil(minutes/60.0));
        return hours * hourlyRate;
    }
}
