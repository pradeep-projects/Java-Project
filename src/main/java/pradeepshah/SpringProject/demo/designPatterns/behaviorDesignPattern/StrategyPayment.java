package pradeepshah.SpringProject.demo.designPatterns.behaviorDesignPattern;

/*
client -> shopping cart ---has a -> Payment Strategy (interface): pay() --is a-> CreditCardStrategy, UpiStrategy, NetBankingStrategy (concrete class)


*/




public class StrategyPayment {
        public interface PaymentStrategy{
            public  void pay(double amount);
        }
        public static class CardStrategy implements PaymentStrategy{
            String cardNumber;
            double balance;

            public CardStrategy(String cardNumber, double balance){
                this.balance = balance;
                this.cardNumber = cardNumber;
            }
            @Override
            public void pay(double amount){
                System.out.println("Credit card payment strategy : amount deducted : " + amount + " balance amount : " + (balance - amount));
            }
        }

    public static class UpiStrategy implements PaymentStrategy{
        String UpiId;
        double balance;

        public UpiStrategy(String UpiId, double balance){
            this.balance = balance;
            this.UpiId = UpiId;
        }
        @Override
        public void pay(double amount){
            System.out.println("Upi payment strategy : amount deducted : " + amount + " balance amount : " + (balance - amount));
        }
    }

    public static class NBStrategy implements PaymentStrategy{
        String accountNumber;
        double balance;

        public NBStrategy(String accountNumber, double balance){
            this.balance = balance;
            this.accountNumber = accountNumber;
        }
        @Override
        public void pay(double amount){
            System.out.println("NB payment strategy : amount deducted : " + amount + " balance amount : "
                    + (balance - amount));
        }
    }

    public static class ShoppingCart{
            private PaymentStrategy paymentStrategy;
            public ShoppingCart(PaymentStrategy paymentStrategy){
                this.paymentStrategy = paymentStrategy;
            }
            public void pay(double amount){
                System.out.println("Strategy :  "  + this.paymentStrategy.getClass().getSimpleName());
                paymentStrategy.pay(amount);
            }

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }
    }

    public static void main(String[] args){
        System.out.println("###### Strategy Design Pattern ######");
        System.out.println("###### Example: Payment Modes: ####");

        // create the shopping cart and set the payment strategy
        ShoppingCart cart = new ShoppingCart(new CardStrategy("4389-5499-5893-4543", 1000.00));
        cart.pay(200);

        cart.setPaymentStrategy(new NBStrategy("000-5499-5893-4543", 3000));
        cart.pay(500);

        cart.setPaymentStrategy(new UpiStrategy("vpa@ybl", 500));
        cart.pay(400);
    }
}
