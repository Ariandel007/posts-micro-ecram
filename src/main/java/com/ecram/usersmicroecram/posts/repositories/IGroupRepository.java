package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Long> {

}
