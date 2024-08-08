package com.vakya.splitwise.controllers;

import com.vakya.splitwise.dtos.*;
import com.vakya.splitwise.dtos.ResponseStatus;
import com.vakya.splitwise.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateGroupResponseDto> createGroup(@RequestBody CreateGroupRequestDto requestDto){
        CreateGroupResponseDto responseDto = new CreateGroupResponseDto();
        try{
            responseDto.setGroup(groupService.createGroup(requestDto.getName(), requestDto.getDescription(), requestDto.getCreatorUserId()));
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return ResponseEntity.status(500).body(responseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteGroupResponseDto> deleteGroup(@RequestBody DeleteGroupRequestDto requestDto){
        DeleteGroupResponseDto responseDto = new DeleteGroupResponseDto();
        try{
            groupService.deleteGroup(requestDto.getGroupId(), requestDto.getUserId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            e.printStackTrace();
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/add-member")
    public ResponseEntity<AddMemberResponseDto> addMember(@RequestBody AddMemberRequestDto requestDto){
        AddMemberResponseDto responseDto = new AddMemberResponseDto();
        try{
            responseDto.setGroupMember(groupService.addMember(requestDto.getGroupId(), requestDto.getAdminId(), requestDto.getMemberId()));
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/remove-member")
    public ResponseEntity<RemoveMemberResponseDto> removeMember(@RequestBody RemoveMemberRequestDto requestDto){
        RemoveMemberResponseDto responseDto = new RemoveMemberResponseDto();
        try{
            groupService.removeMember(requestDto.getGroupId(), requestDto.getAdminId(), requestDto.getMemberId());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            e.printStackTrace();
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/fetch-members")
    public ResponseEntity<FetchMembersResponseDto> fetchMembers(@RequestBody FetchMembersRequestDto requestDto) {
        FetchMembersResponseDto responseDto = new FetchMembersResponseDto();
        try {
            responseDto.setMembers(groupService.fetchAllMembers(requestDto.getGroupId(), requestDto.getMemberId()));
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return ResponseEntity.ok(responseDto);
    }
}
