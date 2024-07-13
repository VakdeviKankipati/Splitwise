package com.vakya.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String password;
}
