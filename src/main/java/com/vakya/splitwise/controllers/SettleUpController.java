package com.vakya.splitwise.controllers;

import com.vakya.splitwise.dtos.*;
import com.vakya.splitwise.models.Expense;
import com.vakya.splitwise.models.Transaction;
import com.vakya.splitwise.services.SettleUpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/settle-up")
public class SettleUpController {

    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService){

        this.settleUpService=settleUpService;
    }

    @PostMapping("/group")
    public SettleUpGroupResponseDto settleGroup(@RequestBody SettleUpGroupRequestDto dto){
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

    @PostMapping("/users")
    public SettleUpGroupResponseDto settleUser(@RequestBody SettleUpUserRequestDto requestDto){
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
