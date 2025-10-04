package pradeepshah.SpringProject.demo.AtmLLD;


import java.util.Date;
import java.util.Map;

/**
 * requirements-ATM machinee
 * Requirements summary
 * → (Card insert, PIN auth, withdraw, print receipt, etc.)
 *Key classes and patterns
 * → ATM, ATMState, IdleState, HasCardState, AuthenticateState, etc. state design pattern
 *
 * Flow
 * → Idle → HasCard → Authenticated → Transaction → Exit
 *
 * Extendability
 * → Add CheckBalanceState, ResetPinState, PrintReceiptState, etc.
 *
 * Patterns summary
 * → State, Singleton, Strategy
 */

import java.util.*;

public class AtmLLD {

    enum NotesType {
        FIVEHUNDRED(500), TWOHUNDRED(200), HUNDRED(100);
        private final int value;
        NotesType(int value) { this.value = value; }
        public int getValue() { return value; }
    }

    /*---------------------- ATM Balance ----------------------*/
    static class AtmBalance {
        Map<NotesType, Integer> notes = new EnumMap<>(NotesType.class);

        public AtmBalance(int f, int t, int h) {
            notes.put(NotesType.FIVEHUNDRED, f);
            notes.put(NotesType.TWOHUNDRED, t);
            notes.put(NotesType.HUNDRED, h);
        }

        public int getTotal() {
            return notes.entrySet().stream()
                    .mapToInt(e -> e.getKey().getValue() * e.getValue())
                    .sum();
        }

        public boolean withdrawAmount(int amount) {
            if (amount > getTotal()) {
                System.out.println("ATM does not have enough cash.");
                return false;
            }

            int remaining = amount;
            for (NotesType note : NotesType.values()) {
                int noteVal = note.getValue();
                int available = notes.get(note);
                int needed = Math.min(remaining / noteVal, available);
                notes.put(note, available - needed);
                remaining -= needed * noteVal;
            }

            if (remaining > 0) {
                System.out.println("Unable to dispense exact amount.");
                return false;
            }

            System.out.println("Dispensed ₹" + amount + " successfully.");
            return true;
        }
    }

    /*---------------------- State Interface ----------------------*/
    interface ATMState {
        void insertCard(ATM atm);
        void authenticate(ATM atm, String pin);
        void withdrawCash(ATM atm, int amount);
        void checkBalance(ATM atm);
        void resetPin(ATM atm, String newPin);
        void printReceipt(ATM atm);
        void ejectCard(ATM atm);
    }

    /*---------------------- Concrete States ----------------------*/
    static class IdleState implements ATMState {
        public void insertCard(ATM atm) {
            System.out.println("Card inserted. Please enter your PIN.");
            atm.setCurrentState(new HasCardState());
        }
        public void authenticate(ATM atm, String pin) { System.out.println("Insert card first!"); }
        public void withdrawCash(ATM atm, int amount) { System.out.println("Insert card first!"); }
        public void checkBalance(ATM atm) { System.out.println("Insert card first!"); }
        public void resetPin(ATM atm, String newPin) { System.out.println("Insert card first!"); }
        public void printReceipt(ATM atm) { System.out.println("Insert card first!"); }
        public void ejectCard(ATM atm) { System.out.println("No card to eject."); }
    }

    static class HasCardState implements ATMState {
        public void insertCard(ATM atm) { System.out.println("Card already inserted!"); }
        public void authenticate(ATM atm, String pin) {
            if ("1234".equals(pin)) {
                System.out.println("Authentication successful.");
                atm.setCurrentState(new AuthenticatedState());
            } else {
                System.out.println("Incorrect PIN. Card ejected.");
                atm.setCurrentState(new IdleState());
            }
        }
        public void withdrawCash(ATM atm, int amount) { System.out.println("Authenticate first!"); }
        public void checkBalance(ATM atm) { System.out.println("Authenticate first!"); }
        public void resetPin(ATM atm, String newPin) { System.out.println("Authenticate first!"); }
        public void printReceipt(ATM atm) { System.out.println("Authenticate first!"); }
        public void ejectCard(ATM atm) {
            System.out.println("Card ejected.");
            atm.setCurrentState(new IdleState());
        }
    }

    static class AuthenticatedState implements ATMState {
        public void insertCard(ATM atm) { System.out.println("Card already inserted."); }
        public void authenticate(ATM atm, String pin) { System.out.println("Already authenticated."); }

        public void withdrawCash(ATM atm, int amount) {
            atm.setCurrentState(new WithdrawMoneyState());
            atm.getCurrentState().withdrawCash(atm, amount);
        }

        public void checkBalance(ATM atm) {
            atm.setCurrentState(new CheckBalanceState());
            atm.getCurrentState().checkBalance(atm);
        }

        public void resetPin(ATM atm, String newPin) {
            atm.setCurrentState(new ResetPinState());
            atm.getCurrentState().resetPin(atm, newPin);
        }

        public void printReceipt(ATM atm) {
            atm.setCurrentState(new PrintReceiptState());
            atm.getCurrentState().printReceipt(atm);
        }

        public void ejectCard(ATM atm) {
            System.out.println("Card ejected.");
            atm.setCurrentState(new IdleState());
        }
    }

    static class WithdrawMoneyState implements ATMState {
        public void insertCard(ATM atm) { System.out.println("Transaction in progress."); }
        public void authenticate(ATM atm, String pin) { System.out.println("Already authenticated."); }
        public void withdrawCash(ATM atm, int amount) {
            if (atm.getAtmBalance().withdrawAmount(amount)) {
                System.out.println("Cash withdrawn successfully.");
                atm.setCurrentState(new PrintReceiptState());
            } else {
                System.out.println("Withdrawal failed. Please try again.");
                atm.setCurrentState(new AuthenticatedState());
            }
        }
        public void checkBalance(ATM atm) { System.out.println("Please complete transaction."); }
        public void resetPin(ATM atm, String newPin) { System.out.println("Please complete transaction."); }
        public void printReceipt(ATM atm) { System.out.println("Complete withdrawal first."); }
        public void ejectCard(ATM atm) { System.out.println("Card ejected."); atm.setCurrentState(new IdleState()); }
    }

    static class CheckBalanceState implements ATMState {
        public void insertCard(ATM atm) { System.out.println("Card already inserted."); }
        public void authenticate(ATM atm, String pin) { System.out.println("Already authenticated."); }
        public void withdrawCash(ATM atm, int amount) { System.out.println("Switch to withdraw option."); }
        public void checkBalance(ATM atm) {
            System.out.println("Your account balance: ₹" + atm.getAtmBalance().getTotal());
            atm.setCurrentState(new AuthenticatedState());
        }
        public void resetPin(ATM atm, String newPin) { System.out.println("Go to reset pin screen."); }
        public void printReceipt(ATM atm) { System.out.println("Print balance receipt."); }
        public void ejectCard(ATM atm) { System.out.println("Card ejected."); atm.setCurrentState(new IdleState()); }
    }

    static class ResetPinState implements ATMState {
        public void insertCard(ATM atm) { System.out.println("Card already inserted."); }
        public void authenticate(ATM atm, String pin) { System.out.println("Already authenticated."); }
        public void withdrawCash(ATM atm, int amount) { System.out.println("Go to withdraw screen."); }
        public void checkBalance(ATM atm) { System.out.println("Go to balance screen."); }
        public void resetPin(ATM atm, String newPin) {
            System.out.println("PIN reset successful to " + newPin);
            atm.setCurrentState(new AuthenticatedState());
        }
        public void printReceipt(ATM atm) { System.out.println("Go to receipt screen."); }
        public void ejectCard(ATM atm) { System.out.println("Card ejected."); atm.setCurrentState(new IdleState()); }
    }

    static class PrintReceiptState implements ATMState {
        public void insertCard(ATM atm) { System.out.println("Printing in progress."); }
        public void authenticate(ATM atm, String pin) { System.out.println("Already authenticated."); }
        public void withdrawCash(ATM atm, int amount) { System.out.println("Please wait, printing receipt."); }
        public void checkBalance(ATM atm) { System.out.println("Please wait, printing receipt."); }
        public void resetPin(ATM atm, String newPin) { System.out.println("Please wait, printing receipt."); }
        public void printReceipt(ATM atm) {
            System.out.println("----- Receipt -----");
            System.out.println("Transaction successful. Thank you!");
            atm.setCurrentState(new TransactionCompleteState());
        }
        public void ejectCard(ATM atm) { System.out.println("Please collect your card."); atm.setCurrentState(new IdleState()); }
    }

    static class TransactionCompleteState implements ATMState {
        public void insertCard(ATM atm) { System.out.println("Please wait, completing transaction."); }
        public void authenticate(ATM atm, String pin) { System.out.println("Transaction completed."); }
        public void withdrawCash(ATM atm, int amount) { System.out.println("Transaction completed."); }
        public void checkBalance(ATM atm) { System.out.println("Transaction completed."); }
        public void resetPin(ATM atm, String newPin) { System.out.println("Transaction completed."); }
        public void printReceipt(ATM atm) { System.out.println("Transaction completed."); }
        public void ejectCard(ATM atm) {
            System.out.println("Card ejected. Have a nice day!");
            atm.setCurrentState(new IdleState());
        }
    }

    /*---------------------- Context Class ----------------------*/
    static class ATM {
        private ATMState currentState;
        private AtmBalance atmBalance;

        public ATM(AtmBalance atmBalance) {
            this.atmBalance = atmBalance;
            this.currentState = new IdleState();
        }

        public void setCurrentState(ATMState newState) { this.currentState = newState; }
        public ATMState getCurrentState() { return currentState; }
        public AtmBalance getAtmBalance() { return atmBalance; }

        // Delegated actions
        public void insertCard() { currentState.insertCard(this); }
        public void authenticate(String pin) { currentState.authenticate(this, pin); }
        public void withdrawCash(int amount) { currentState.withdrawCash(this, amount); }
        public void checkBalance() { currentState.checkBalance(this); }
        public void resetPin(String newPin) { currentState.resetPin(this, newPin); }
        public void printReceipt() { currentState.printReceipt(this); }
        public void ejectCard() { currentState.ejectCard(this); }
    }

    /*---------------------- Demo ----------------------*/
    public static void main(String[] args) {
        ATM atm = new ATM(new AtmBalance(10, 10, 10));

        atm.insertCard();
        atm.authenticate("1234");
        atm.checkBalance();
        atm.withdrawCash(1700);
        atm.printReceipt();
        atm.resetPin("5678");
        atm.ejectCard();
    }
}
