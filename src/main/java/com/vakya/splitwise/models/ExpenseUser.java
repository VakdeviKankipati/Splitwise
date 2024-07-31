package com.vakya.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseUser extends BaseModel{
    @ManyToOne(fetch = FetchType.EAGER)
    private Expense expense;

    private double amount;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}
