package pradeepshah.SpringProject.demo.splitWise.expense;

import pradeepshah.SpringProject.demo.splitWise.BalanceSheetController;
import pradeepshah.SpringProject.demo.splitWise.expense.split.ExpenseSplit;
import pradeepshah.SpringProject.demo.splitWise.expense.split.Split;
import pradeepshah.SpringProject.demo.splitWise.user.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }
    public Expense createExpense(String expenseId, String description, Double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){

        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validate(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }

}
