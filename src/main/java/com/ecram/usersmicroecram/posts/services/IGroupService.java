package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.models.Group;
import org.springframework.stereotype.Service;

public interface IGroupService {
    Group saveGroup(Group group);
}
