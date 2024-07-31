package com.vakya.splitwise.dtos;

import com.vakya.splitwise.models.GroupMember;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberResponseDto {
    private ResponseStatus responseStatus;
    private GroupMember groupMember;
}
