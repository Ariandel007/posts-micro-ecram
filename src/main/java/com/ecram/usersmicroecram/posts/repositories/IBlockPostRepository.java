package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.BlockPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlockPostRepository extends JpaRepository<BlockPost, Long> {

}
