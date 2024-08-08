package com.vakya.splitwise.dtos;

import com.vakya.splitwise.models.Group;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupResponseDto {
    private Group group;
    private ResponseStatus responseStatus;
}
