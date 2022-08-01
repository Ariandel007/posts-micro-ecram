package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.models.DataBlockPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataBlockPostRepository extends JpaRepository<DataBlockPost, Long> {

}
