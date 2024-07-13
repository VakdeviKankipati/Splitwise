package com.vakya.splitwise.strategy;

import com.vakya.splitwise.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
