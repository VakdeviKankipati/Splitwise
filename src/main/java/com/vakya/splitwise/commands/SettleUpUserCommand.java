package com.vakya.splitwise.commands;

import com.vakya.splitwise.controllers.SettleUpController;
import com.vakya.splitwise.dtos.SettleUpUserRequestDto;
import com.vakya.splitwise.dtos.SettleUpUserResponseDto;

import java.util.List;

public class SettleUpUserCommand implements Command{
    private SettleUpController settleUpController;

    public SettleUpUserCommand(SettleUpController settleUpController){
        this.settleUpController=settleUpController;
    }
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==2 && words.get(1).equals(CommandKeywords.settleUpCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));

        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDto requestDto = new SettleUpUserRequestDto();
        requestDto.setUserId(userId);

        //SettleUpUserResponseDto responseDto = settleUpController.settleUpUser(requestDto);

    }
}
