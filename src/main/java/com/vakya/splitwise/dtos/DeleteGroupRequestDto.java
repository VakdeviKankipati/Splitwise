package com.vakya.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteGroupRequestDto {
    private long groupId;
    private long userId;
}
