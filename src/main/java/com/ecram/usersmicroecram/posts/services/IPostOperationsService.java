package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.dtos.request.PostToCreateDto;
import com.ecram.usersmicroecram.posts.dtos.response.PostCreatedDto;
import com.ecram.usersmicroecram.posts.dtos.response.PostFindedDto;

public interface IPostOperationsService {
    PostCreatedDto createPost(Long userId, PostToCreateDto postToCreateDto);
    PostFindedDto findPostById(Long postId);
}
