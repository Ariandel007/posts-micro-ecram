package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment,Long> {

}
