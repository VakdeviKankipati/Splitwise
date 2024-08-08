package com.vakya.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupRequestDto {
    private String name;
    private String description;
    private Long creatorUserId;
}
