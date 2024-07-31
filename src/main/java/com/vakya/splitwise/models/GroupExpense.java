package com.vakya.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "group_expenses")
public class GroupExpense extends BaseModel{
    @ManyToOne(fetch = FetchType.EAGER)
    private Group group;
    @ManyToOne(fetch = FetchType.EAGER)
    private Expense expense;
}
