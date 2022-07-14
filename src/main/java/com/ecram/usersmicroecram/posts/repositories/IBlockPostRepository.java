package com.ecram.usersmicroecram.posts.repositories;

import org.springframework.cglib.core.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlockPostRepository extends JpaRepository<Block, Long> {

}
