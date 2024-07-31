package com.vakya.splitwise.strategy;

import com.vakya.splitwise.models.Expense;
import com.vakya.splitwise.models.Transaction;
import com.vakya.splitwise.models.User;

import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {
    //List<Expense> settleUp(List<Expense> expenses);
    public List<Transaction> settleUp(Map<User, Double> aggregateExpenses);
}
