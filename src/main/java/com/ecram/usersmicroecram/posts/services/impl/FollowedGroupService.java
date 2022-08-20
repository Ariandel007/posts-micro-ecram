package com.ecram.usersmicroecram.posts.services.impl;

import com.ecram.usersmicroecram.posts.models.FollowedGroup;
import com.ecram.usersmicroecram.posts.repositories.IFollowedGroupRepository;
import com.ecram.usersmicroecram.posts.services.IFollowedGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class FollowedGroupService implements IFollowedGroupService {

    private final IFollowedGroupRepository followedGroupRepository;

    @Autowired
    public FollowedGroupService(IFollowedGroupRepository followedGroupRepository) {
        this.followedGroupRepository = followedGroupRepository;
    }

    @Override
    @Transactional
    public FollowedGroup saveFollowedGroup(Long idUser, Long idGroup, String permissionGroup) {
        Instant today = Instant.now();

        FollowedGroup followedGroup = new FollowedGroup();
        followedGroup.setId_group(idGroup);
        followedGroup.setIdUserApp(idUser);
        followedGroup.setPermisionGroup(permissionGroup);
        followedGroup.setName("default_alias");
        followedGroup.setCreateDate(today);
        followedGroup.setCreateDateUtc(today.toString());
        followedGroup.setModifyDate(today);
        followedGroup.setModifyDateUtc(today.toString());


        return this.followedGroupRepository.save(followedGroup);
    }
}
