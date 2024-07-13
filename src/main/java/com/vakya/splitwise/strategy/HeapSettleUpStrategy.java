package com.vakya.splitwise.strategy;

import com.vakya.splitwise.models.Expense;

import java.util.List;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        return List.of();
    }
}
