package pradeepshah.SpringProject.demo.parkingLotDemo;

public class ExitGate {
    private final ParkingLot parkingLot;
    private final PricingStrategy pricingStrategy;
    private final PaymentProcessor paymentProcessor;
    public ExitGate(ParkingLot lot, PricingStrategy pricingStrategy, PaymentProcessor paymentProcessor){
        this.parkingLot = lot; this.pricingStrategy = pricingStrategy; this.paymentProcessor = paymentProcessor;
    }
    public boolean processExit(String ticketId){
        return parkingLot.handleExit(ticketId, pricingStrategy, paymentProcessor);
    }

}
