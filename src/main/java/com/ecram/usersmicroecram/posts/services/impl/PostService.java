package com.ecram.usersmicroecram.posts.services.impl;

import com.ecram.usersmicroecram.posts.dtos.response.PostToListDto;
import com.ecram.usersmicroecram.posts.models.Post;
import com.ecram.usersmicroecram.posts.repositories.IPostRepository;
import com.ecram.usersmicroecram.posts.services.IPostService;
import com.ecram.usersmicroecram.posts.utils.PostStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class PostService implements IPostService {

    private final IPostRepository postRepository;

    @Autowired
    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public Post savePost(Post postToSave) {
        Instant today = Instant.now();

        postToSave.setLikeNumber(0L);
        postToSave.setDislikeNumber(0L);
        postToSave.setStatus(PostStates.enable.toString());
        postToSave.setCreateDate(today);
        postToSave.setCreateDateUtc(today.toString());
        postToSave.setModifyDate(today);
        postToSave.setModifyDateUtc(today.toString());

        return this.postRepository.save(postToSave);
    }

    @Override
    public List<PostToListDto> listPostsInUserInboxByGroup(Long idGroup, Long cursor) {
        return this.postRepository.listPostsInUserInboxByGroup(idGroup, cursor);
    }
}
