package com.vakya.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveMemberRequestDto {
    private long groupId;
    private long adminId;
    private long memberId;
}
