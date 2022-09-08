package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long>, ICustomPostRepository {

}
