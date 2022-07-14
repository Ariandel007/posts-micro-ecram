package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.FollowedGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowedGroupRepository extends JpaRepository<FollowedGroup, Long> {

}
