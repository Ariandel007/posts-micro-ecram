package com.ecram.usersmicroecram.posts.services.impl;

import com.ecram.usersmicroecram.posts.models.BlockPost;
import com.ecram.usersmicroecram.posts.repositories.IBlockPostRepository;
import com.ecram.usersmicroecram.posts.services.IBlockPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlockPostService implements IBlockPostService {
    private final IBlockPostRepository blockPostRepository;

    @Autowired
    public BlockPostService(IBlockPostRepository blockPostRepository) {
        this.blockPostRepository = blockPostRepository;
    }

    @Override
    @Transactional
    public BlockPost saveBlockPost(BlockPost blockPost) {
        return this.blockPostRepository.save(blockPost);
    }

    @Override
    @Transactional
    public List<BlockPost> saveManyBlockPost(List<BlockPost> blockPosts) {
        return this.blockPostRepository.saveAll(blockPosts);
    }
}
