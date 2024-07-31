package com.vakya.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{

    private String description;
    private double amount;
    private Date addedAt;
    private String proofUrl;

    /*@ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @ManyToOne
    private Group group;
     */

    @OneToMany(mappedBy = "expense", fetch = FetchType.EAGER)
    private List<ExpenseUser> expenseUsers;



}

/*

   1                M
Expense ------- ExpenseUser => 1:M
   1               1

E1

E1U1 2000 PAID_BY
E1U2
E1U3

XY - X => M:1


   1           1
Expense ---- Group => M:1
   M           1
 */
