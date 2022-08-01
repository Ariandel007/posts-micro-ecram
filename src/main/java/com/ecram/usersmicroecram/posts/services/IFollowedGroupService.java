package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.models.FollowedGroup;
import org.springframework.stereotype.Service;

@Service
public interface IFollowedGroupService {
    FollowedGroup saveFollowedGroup(Long idUser, Long idGroup, String permissionGroup);
}
