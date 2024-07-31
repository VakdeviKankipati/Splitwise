package com.vakya.splitwise.services;

import com.vakya.splitwise.exception.InvalidGroupException;
import com.vakya.splitwise.exception.InvalidUserException;
import com.vakya.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpService {
    public List<Transaction> settleGroup(long groupId) throws InvalidGroupException;

    public List<Transaction> settleUser(long userId) throws InvalidUserException;
}
