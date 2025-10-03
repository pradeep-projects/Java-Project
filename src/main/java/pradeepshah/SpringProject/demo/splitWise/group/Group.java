package pradeepshah.SpringProject.demo.splitWise.group;

import pradeepshah.SpringProject.demo.splitWise.expense.Expense;
import pradeepshah.SpringProject.demo.splitWise.expense.ExpenseController;
import pradeepshah.SpringProject.demo.splitWise.expense.ExpenseSplitType;
import pradeepshah.SpringProject.demo.splitWise.expense.split.Split;
import pradeepshah.SpringProject.demo.splitWise.user.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;
    // expense controller
    ExpenseController expenseController;
    public Group(){
    groupMembers = new ArrayList<>();
    expenseList = new ArrayList<>();
    // initialize the expenseController
    expenseController = new ExpenseController();
    }

    // add members in group
    public void addMember(User user){
        groupMembers.add(user);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    // write create Expense method
    public Expense createExpense(String expenseId, String description, Double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {

        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }

}
