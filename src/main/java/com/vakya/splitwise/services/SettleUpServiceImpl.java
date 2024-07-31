package com.vakya.splitwise.services;


import com.vakya.splitwise.exception.InvalidGroupException;
import com.vakya.splitwise.exception.InvalidUserException;
import com.vakya.splitwise.models.*;
import com.vakya.splitwise.repositories.*;
import com.vakya.splitwise.strategy.SettleUpStrategy;
import com.vakya.splitwise.utils.ExpenseUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class SettleUpServiceImpl implements SettleUpService {

    private GroupExpenseRepository groupExpenseRepository;
    private ExpenseRepository expenseRepository;
    private GroupRepository groupRepository;
    private UserRepository userRepository;
    private SettleUpStrategy settleUpStrategy;


    public SettleUpServiceImpl(GroupExpenseRepository groupExpenseRepository, ExpenseRepository expenseRepository, GroupRepository groupRepository, UserRepository userRepository, SettleUpStrategy settleUpStrategy) {
        this.groupExpenseRepository = groupExpenseRepository;
        this.expenseRepository = expenseRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.settleUpStrategy = settleUpStrategy;
    }





    @Override
    public List<Transaction> settleGroup(long groupId) throws InvalidGroupException {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new InvalidGroupException("Group not found"));

        List<GroupExpense> groupExpenses = groupExpenseRepository.findByGroupId(groupId);
        List<Expense> expenses = groupExpenses.stream().map(GroupExpense::getExpense).collect(Collectors.toList());
        Map<User, Double> aggregateExpenses = ExpenseUtils.aggregateExpenses(expenses);
        return settleUpStrategy.settleUp(aggregateExpenses);
    }

    @Override
    public List<Transaction> settleUser(long userId) throws InvalidUserException {
        User user = userRepository.findById(userId).orElseThrow(() -> new InvalidUserException("User not found"));
        List<Expense> expenses = this.expenseRepository.findNonGroupExpensesForUser(userId);
        Map<User, Double> aggregateExpenses = ExpenseUtils.aggregateExpenses(expenses);
        return settleUpStrategy.settleUp(aggregateExpenses);
    }
}
