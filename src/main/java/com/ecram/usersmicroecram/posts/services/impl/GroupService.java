package com.ecram.usersmicroecram.posts.services.impl;

import com.ecram.usersmicroecram.posts.models.Group;
import com.ecram.usersmicroecram.posts.repositories.IGroupRepository;
import com.ecram.usersmicroecram.posts.services.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class GroupService implements IGroupService {

    private final IGroupRepository groupRepository;

    @Autowired
    public GroupService(IGroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    @Override
    public Group saveGroup(Group group) {
        Instant today = Instant.now();

        group.setCreateDate(today);
        group.setCreateDateUtc(today.toString());
        group.setModifyDate(today);
        group.setModifyDateUtc(today.toString());

        return this.groupRepository.save(group);
    }
}
