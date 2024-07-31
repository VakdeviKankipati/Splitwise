package com.vakya.splitwise.dtos;

import com.vakya.splitwise.models.Expense;
import com.vakya.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    private List<Transaction> transactions;
    private ResponseStatus responseStatus;
}
