package com.vakya.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Transaction extends BaseModel{
    @ManyToOne
    private User paidFrom;
    @ManyToOne
    private User paidTo;
    private double amount;
}
