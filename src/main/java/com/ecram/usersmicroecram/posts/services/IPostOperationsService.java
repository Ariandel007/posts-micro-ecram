package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.dtos.request.PostToCreateDto;
import com.ecram.usersmicroecram.posts.models.Post;

public interface IPostOperationsService {
    Post createPost(String username, PostToCreateDto postToCreateDto);
}
