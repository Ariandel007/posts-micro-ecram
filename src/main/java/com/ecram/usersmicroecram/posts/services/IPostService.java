package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.dtos.response.PostToListDto;
import com.ecram.usersmicroecram.posts.models.Post;

import java.util.List;

public interface IPostService {
    Post savePost(Post postToSave);
    List<PostToListDto> listPostsInGroupInboxByGroup(Long idGroup, Long cursor);
}
