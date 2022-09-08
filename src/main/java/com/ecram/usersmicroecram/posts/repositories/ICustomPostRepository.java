package com.ecram.usersmicroecram.posts.repositories;

import com.ecram.usersmicroecram.posts.dtos.response.PostToListDto;

import java.util.List;

public interface ICustomPostRepository {
    List<PostToListDto> listPostsInUserInboxByGroup(Long idGroup, Long cursor);
}
