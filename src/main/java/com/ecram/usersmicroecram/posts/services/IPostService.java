package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.models.Post;

public interface IPostService {
    Post savePost(Post postToSave);
}
