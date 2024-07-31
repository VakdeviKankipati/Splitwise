package com.vakya.splitwise.utils;

import com.vakya.splitwise.models.Expense;
import com.vakya.splitwise.models.ExpenseUser;
import com.vakya.splitwise.models.ExpenseUserType;
import com.vakya.splitwise.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseUtils {
    public static Map<User, Double> aggregateExpenses(List<Expense> expenses){
        Map<User, Double> condensedExpenses = new HashMap<>();
        for (Expense expense : expenses) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                User user = expenseUser.getUser();
                double amountForThisExpense = expenseUser.getExpenseUserType().equals(ExpenseUserType.PAID) ? 1 * expenseUser.getAmount(): -1 * expenseUser.getAmount();
                condensedExpenses.put(user,  amountForThisExpense + condensedExpenses.getOrDefault(user, 0d));
            }
        }
        return condensedExpenses;
    }
}
