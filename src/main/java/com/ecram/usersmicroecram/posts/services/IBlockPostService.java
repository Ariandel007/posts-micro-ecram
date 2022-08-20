package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.models.BlockPost;

import java.util.List;

public interface IBlockPostService {
    BlockPost saveBlockPost(BlockPost blockPost);
    List<BlockPost> saveManyBlockPost(List<BlockPost> blockPosts);
}
