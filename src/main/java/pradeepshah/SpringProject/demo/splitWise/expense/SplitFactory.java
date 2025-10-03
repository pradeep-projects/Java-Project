package pradeepshah.SpringProject.demo.splitWise.expense;

import pradeepshah.SpringProject.demo.splitWise.expense.split.EqualExpenseSplit;
import pradeepshah.SpringProject.demo.splitWise.expense.split.ExpenseSplit;
import pradeepshah.SpringProject.demo.splitWise.expense.split.PercentageExpenseSplit;
import pradeepshah.SpringProject.demo.splitWise.expense.split.UnEqualExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType){
        switch (splitType){
            case EQUAL :  return new EqualExpenseSplit();
            case UNEQUAL :  return new UnEqualExpenseSplit();
            case PERCENTAGE :  return new PercentageExpenseSplit();
            default : return null;
        }
    }
}
