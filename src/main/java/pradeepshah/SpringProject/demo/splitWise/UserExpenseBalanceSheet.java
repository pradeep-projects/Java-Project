package pradeepshah.SpringProject.demo.splitWise;

import pradeepshah.SpringProject.demo.splitWise.user.User;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String, Balance> userVsBalance;
    Double totalYourExpense;
    Double totalPayment;

    Double totalYouOwe;
    Double totalYouGetBack;

    public UserExpenseBalanceSheet(){

        userVsBalance = new HashMap<>();
        totalYourExpense = (double) 0;
        totalYouOwe = (double) 0;
        totalPayment = (double) 0;
        totalYouGetBack = (double) 0;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(Double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }

    public Double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(Double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public Double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(Double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }
}

