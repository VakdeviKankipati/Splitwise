package com.vakya.splitwise.services;

import com.vakya.splitwise.exception.InvalidGroupException;
import com.vakya.splitwise.exception.InvalidUserException;
import com.vakya.splitwise.exception.UnAuthorizedAccessException;
import com.vakya.splitwise.models.GroupMember;
import com.vakya.splitwise.models.User;

import java.util.List;

public interface GroupService {
    public GroupMember addMember(long groupId, long adminId, long userId) throws InvalidGroupException, InvalidUserException, UnAuthorizedAccessException;

    public void removeMember(long groupId, long adminId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException;

    public List<User> fetchAllMembers(long groupId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException;
}
