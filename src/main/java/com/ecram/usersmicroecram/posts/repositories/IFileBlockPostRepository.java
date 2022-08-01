package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.FileBlockPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFileBlockPostRepository extends JpaRepository<FileBlockPost, Long> {

}
