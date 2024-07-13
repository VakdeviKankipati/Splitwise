package com.vakya.splitwise.repositories;

import com.vakya.splitwise.models.Expense;
import com.vakya.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findAllByGroup(Group group);
}
