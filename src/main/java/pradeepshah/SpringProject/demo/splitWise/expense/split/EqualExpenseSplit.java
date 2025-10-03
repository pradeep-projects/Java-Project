package pradeepshah.SpringProject.demo.splitWise.expense.split;

import java.util.List;
import java.util.Objects;

public class EqualExpenseSplit implements ExpenseSplit{
    @Override
    public void validate(List<Split> splitList, Double totalAmount){
        Double amountShouldBePresent = totalAmount/splitList.size();
        for(Split split: splitList){
            if(!amountShouldBePresent.equals(split.getAmountOwe())){
                // throw exceptions
            }
        }
    }
}
