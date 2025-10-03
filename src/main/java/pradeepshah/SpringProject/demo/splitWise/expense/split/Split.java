package pradeepshah.SpringProject.demo.splitWise.expense.split;

import lombok.Data;
import pradeepshah.SpringProject.demo.splitWise.user.User;

public class Split {
    User user;
    Double amountOwe;
    public Split(User user, Double amountOwe){
        this.user = user;
        this.amountOwe = amountOwe;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }

    public Double getAmountOwe() {
        return amountOwe;
    }
    public void setAmountOwe(Double amountOwe){
        this.amountOwe = amountOwe;
    }
}
