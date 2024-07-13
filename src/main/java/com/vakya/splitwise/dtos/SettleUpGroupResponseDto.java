package com.vakya.splitwise.dtos;

import com.vakya.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Expense> expenses;
}
