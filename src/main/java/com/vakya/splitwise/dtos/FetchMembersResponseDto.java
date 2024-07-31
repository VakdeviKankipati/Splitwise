package com.vakya.splitwise.dtos;

import com.vakya.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FetchMembersResponseDto {
    private List<User> members;
    private ResponseStatus responseStatus;
}
