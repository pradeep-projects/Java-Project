package pradeepshah.SpringProject.demo.splitWise;

public class Balance {
    Double amountOwe;
    Double amountGetBack;

    public Balance(){
        amountGetBack=0.00;
        amountOwe = 0.00;
    }

    public Double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(Double amountOwe) {
        this.amountOwe = amountOwe;
    }

    public Double getAmountGetBack() {
        return amountGetBack;
    }

    public void setAmountGetBack(Double amountGetBack) {
        this.amountGetBack = amountGetBack;
    }
}
