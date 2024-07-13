package com.vakya.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "splitwise_groups")
public class Group extends BaseModel{

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(name = "user_join")
    private List<User> users1;

    @ManyToOne
    private User createdBy;

    @OneToMany
    private List<Expense> expenses;
}
