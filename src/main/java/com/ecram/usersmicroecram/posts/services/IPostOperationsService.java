package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.dtos.request.PostToCreateDto;
import com.ecram.usersmicroecram.posts.dtos.response.PostCreatedDto;

public interface IPostOperationsService {
    PostCreatedDto createPost(Long userId, PostToCreateDto postToCreateDto);
}
