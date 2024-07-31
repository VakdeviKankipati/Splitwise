package com.vakya.splitwise.controllers;

import com.vakya.splitwise.dtos.*;
import com.vakya.splitwise.models.Expense;
import com.vakya.splitwise.models.Transaction;
import com.vakya.splitwise.services.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService){

        this.settleUpService=settleUpService;
    }

    public SettleUpGroupResponseDto settleGroup(SettleUpGroupRequestDto dto){
        SettleUpGroupResponseDto responseDto = new SettleUpGroupResponseDto();
        try {
            List<Transaction> transactions = settleUpService.settleGroup(dto.getGroupId());
            responseDto.setTransactions(transactions);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    public SettleUpGroupResponseDto settleUser(SettleUpUserRequestDto requestDto){
        SettleUpGroupResponseDto responseDto = new SettleUpGroupResponseDto();
        try{
            List<Transaction> transactions = settleUpService.settleUser(requestDto.getUserId());
            responseDto.setTransactions(transactions);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
