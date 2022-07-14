package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupRepository extends JpaRepository<Group, Long> {

}
