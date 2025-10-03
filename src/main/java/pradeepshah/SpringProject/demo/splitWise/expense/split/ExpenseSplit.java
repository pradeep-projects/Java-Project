package pradeepshah.SpringProject.demo.splitWise.expense.split;

import java.util.List;

public interface ExpenseSplit {
    public void validate(List<Split> splitList, Double totalAmount);
}
