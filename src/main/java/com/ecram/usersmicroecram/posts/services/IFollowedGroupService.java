package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.models.FollowedGroup;

public interface IFollowedGroupService {
    FollowedGroup saveFollowedGroup(Long idUser, Long idGroup, String permissionGroup);
}
