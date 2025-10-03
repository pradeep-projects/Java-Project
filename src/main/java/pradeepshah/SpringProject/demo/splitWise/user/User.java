package pradeepshah.SpringProject.demo.splitWise.user;

import pradeepshah.SpringProject.demo.splitWise.UserExpenseBalanceSheet;

public class User {
    String id;
    String name;
    // balance Sheet

    UserExpenseBalanceSheet userExpenseBalanceSheet;
    public User(String id, String name){
        this.id = id;
        this.name = name;
        // initialize the balanse sheet;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }
    public String getUserId(){
        return id;
    }

    // get balance sheet method
    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

}
