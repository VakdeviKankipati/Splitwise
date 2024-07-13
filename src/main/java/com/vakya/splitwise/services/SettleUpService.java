package com.vakya.splitwise.services;

import com.vakya.splitwise.models.Expense;
import com.vakya.splitwise.repositories.ExpenseRepository;
import com.vakya.splitwise.repositories.ExpenseUserRepository;
import com.vakya.splitwise.repositories.GroupRepository;
import com.vakya.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettleUpService {

    private ExpenseRepository expenseRepository;
    private ExpenseUserRepository expenseUserRepository;
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    public SettleUpService(ExpenseRepository expenseRepository,
                           ExpenseUserRepository expenseUserRepository,
                           GroupRepository groupRepository,
                           UserRepository userRepository){
        this.expenseRepository=expenseRepository;
        this.expenseUserRepository=expenseUserRepository;
        this.groupRepository=groupRepository;
        this.userRepository=userRepository;
    }


    public List<Expense> settleUpGroup(Long groupId) {
          /*
        1. Get the user with the given userId.
        2. Get all the expenses for this user.
        3. Iterate through all the expenses, and find out total extra/lesser amount
        paid by every user involved in the expenses.
        4. Implement Min/Max Heap algorithm to settle up users.
         */


        return null;
    }

    public List<Expense> settleUpUser(Long userId) {
        return null;
    }
}
