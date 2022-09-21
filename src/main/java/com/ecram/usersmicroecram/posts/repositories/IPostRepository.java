package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long>, ICustomPostRepository {
    @Query(" SELECT p FROM Post p                        " +
           " join fetch p.blockPostList bpl              " +
           " join fetch bpl.dataBlockPost dbp            " +
           " join fetch dbp.fileBlockPostRelated fbpr    " +
           " WHERE p.id = :postId AND p.status='enable'  ")
    Post findPostData(@Param("postId") Long postId);

}
