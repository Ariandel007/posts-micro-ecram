package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.BlockPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlockPostRepository extends JpaRepository<BlockPost, Long> {

}
