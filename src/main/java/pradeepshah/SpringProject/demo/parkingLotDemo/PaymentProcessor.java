package pradeepshah.SpringProject.demo.parkingLotDemo;

public class PaymentProcessor {
    public boolean pay(Ticket ticket, double amount){
        // pretend process succeeded
        ticket.amount = amount;
        ticket.paid = true;
        return true;
    }
}
