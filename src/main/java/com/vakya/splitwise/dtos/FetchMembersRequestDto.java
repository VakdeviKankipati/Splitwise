package com.vakya.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FetchMembersRequestDto {
    private long groupId;
    private long memberId;
}
