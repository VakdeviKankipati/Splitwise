package com.vakya.splitwise.services;

import com.vakya.splitwise.exception.InvalidGroupException;
import com.vakya.splitwise.exception.InvalidUserException;
import com.vakya.splitwise.exception.UnAuthorizedAccessException;
import com.vakya.splitwise.models.Group;
import com.vakya.splitwise.models.GroupAdmin;
import com.vakya.splitwise.models.GroupMember;
import com.vakya.splitwise.models.User;
import com.vakya.splitwise.repositories.GroupAdminRepository;
import com.vakya.splitwise.repositories.GroupMemberRepository;
import com.vakya.splitwise.repositories.GroupRepository;
import com.vakya.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final GroupAdminRepository groupAdminRepository;
    private final GroupMemberRepository groupMemberRepository;


    public GroupServiceImpl(GroupRepository groupRepository, UserRepository userRepository, GroupAdminRepository groupAdminRepository, GroupMemberRepository groupMemberRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.groupAdminRepository = groupAdminRepository;
        this.groupMemberRepository = groupMemberRepository;
    }
    @Override
    public GroupMember addMember(long groupId, long adminId, long userId) throws InvalidGroupException, InvalidUserException, UnAuthorizedAccessException {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new InvalidGroupException("Group not found"));

        GroupAdmin groupAdmin = groupAdminRepository.findByGroupIdAndAdminId(groupId, adminId).orElseThrow(() -> new UnAuthorizedAccessException("The given user is not an admin of the group"));
        User memberToBeAdded = userRepository.findById(userId).orElseThrow(() -> new InvalidUserException("The given user does not exist"));
        Optional<GroupMember> groupMemberOptional = groupMemberRepository.findByGroupIdAndUserId(groupId, userId);
        if(groupMemberOptional.isPresent()){
            throw new InvalidUserException("The given user is already a member of the group");
        }

        GroupMember groupMember = new GroupMember();
        groupMember.setGroup(group);
        groupMember.setUser(memberToBeAdded);
        groupMember.setAddedBy(groupAdmin.getAdmin());
        groupMember.setAddedAt(new Date());
        return groupMemberRepository.save(groupMember);
    }

    @Override
    public void removeMember(long groupId, long adminId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException {
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new InvalidGroupException("Group not found"));

        GroupAdmin groupAdmin = groupAdminRepository.findByGroupIdAndAdminId(groupId, adminId).orElseThrow(() -> new UnAuthorizedAccessException("The given user is not an admin of the group"));

        User memberToBeRemoved = userRepository.findById(userId).orElseThrow(() -> new InvalidUserException("The given user is not a valid user"));

        Optional<GroupMember> groupMemberOptional = groupMemberRepository.findByGroupIdAndUserId(groupId, userId);

        if(groupMemberOptional.isEmpty()){
            throw new InvalidUserException("The given user is not a member of the group");
        }

        groupMemberRepository.delete(groupMemberOptional.get());
    }

    @Override
    public List<User> fetchAllMembers(long groupId, long userId) throws InvalidGroupException, UnAuthorizedAccessException, InvalidUserException {
        groupRepository.findById(groupId).orElseThrow(() -> new InvalidGroupException("Group not found"));

        userRepository.findById(userId).orElseThrow(() -> new InvalidUserException("The user trying to access the group is not a valid user"));

        Optional<GroupAdmin> groupAdminOptional = groupAdminRepository.findByGroupIdAndAdminId(groupId, userId);
        Optional<GroupMember> groupMemberOptional = groupMemberRepository.findByGroupIdAndUserId(groupId, userId);

        if(groupAdminOptional.isEmpty() && groupMemberOptional.isEmpty()){
            throw new UnAuthorizedAccessException("The given user is not a member of the group");
        }

        List<GroupMember> groupMembers = groupMemberRepository.findAllByGroupId(groupId);

        List<GroupAdmin> groupAdmins = groupAdminRepository.findAllByGroupId(groupId);

        Set<User> users = new HashSet<>();
        for(GroupMember groupMember : groupMembers){
            users.add(groupMember.getUser());
        }
        for(GroupAdmin groupAdmin1 : groupAdmins){
            users.add(groupAdmin1.getAdmin());
        }

        return users.stream().toList();
    }
}
