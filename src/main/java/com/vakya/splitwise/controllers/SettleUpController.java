package com.vakya.splitwise.controllers;

import com.vakya.splitwise.dtos.SettleUpGroupRequestDto;
import com.vakya.splitwise.dtos.SettleUpGroupResponseDto;
import com.vakya.splitwise.dtos.SettleUpUserRequestDto;
import com.vakya.splitwise.dtos.SettleUpUserResponseDto;
import com.vakya.splitwise.models.Expense;
import com.vakya.splitwise.services.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService){
        this.settleUpService=settleUpService;
    }

    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto requestDto){
        SettleUpUserResponseDto responseDto = new SettleUpUserResponseDto();

        List<Expense> expense = settleUpService.settleUpUser(requestDto.getUserId());
        responseDto.setExpenses(expense);

        return responseDto;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto){
        SettleUpGroupResponseDto responseDto = new SettleUpGroupResponseDto();

        List<Expense> expenseList = settleUpService.settleUpGroup(requestDto.getGroupId());
        responseDto.setExpenses(expenseList);

        return responseDto;
    }
}
