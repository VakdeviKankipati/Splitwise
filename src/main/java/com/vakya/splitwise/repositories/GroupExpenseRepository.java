package com.vakya.splitwise.repositories;

import com.vakya.splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Integer> {

    List<GroupExpense> findByGroupId(long groupId);
}