package com.ecram.usersmicroecram.posts.services.impl;

import com.ecram.usersmicroecram.posts.client.IUserClientRest;
import com.ecram.usersmicroecram.posts.dtos.request.BlockPostToCreateDto;
import com.ecram.usersmicroecram.posts.dtos.request.PostToCreateDto;
import com.ecram.usersmicroecram.posts.dtos.response.PostCreatedDto;
import com.ecram.usersmicroecram.posts.models.*;
import com.ecram.usersmicroecram.posts.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostOperationsService implements IPostOperationsService {

    private final IPostService postService;
    private final IBlockPostService blockPostService;
//    private final IDataBlockPostService dataBlockPostService;
//    private final IFileBlockPostService fileBlockPostService;
    private final IUserClientRest userClientRest;
    private final ModelMapper modelMapper;

    @Autowired
    public PostOperationsService(
            IPostService postService,
            IBlockPostService blockPostService,
//            IDataBlockPostService dataBlockPostService,
//            IFileBlockPostService fileBlockPostService,
            IUserClientRest userClientRest,
            ModelMapper modelMapper
    ){
        this.postService = postService;
        this.blockPostService = blockPostService;
//        this.dataBlockPostService = dataBlockPostService;
//        this.fileBlockPostService = fileBlockPostService;
        this.userClientRest = userClientRest;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public PostCreatedDto createPost(String username, PostToCreateDto postToCreateDto) {
        // Traer id de usuario
        Long userId = this.userClientRest.getUserIdByUsername(username).getBody();

        List<BlockPostToCreateDto> blockPostToCreateDtoList = postToCreateDto.getBlockPostToCreateDtoList();

        //TODO: mapear y guardar Post
        Post postToSave = this.modelMapper.map(postToCreateDto, Post.class);
        postToSave.setIdUser(userId);
        postToSave.setBlockPostList(null);
        Post postCreated = this.postService.savePost(postToSave);

        //mapear y guardar BlockPostToCreate(con fe guarda todo)

        List<BlockPost> blockPostListToSave = blockPostToCreateDtoList.stream().map(blockPostToCreateDto -> {
            blockPostToCreateDto.setIdPost(postCreated.getId());
            BlockPost blockPostToSave = this.modelMapper.map(blockPostToCreateDto, BlockPost.class);
            if(blockPostToCreateDto.getDataBlockPostDto() != null) {
                DataBlockPost dataBlockPostToSave =
                        this.modelMapper.map(blockPostToCreateDto.getDataBlockPostDto(), DataBlockPost.class);
                if(blockPostToCreateDto.getDataBlockPostDto().getFileBlockPostDto() != null) {
                    FileBlockPost fileBlockPostToSave =
                            this.modelMapper.map(blockPostToCreateDto.getDataBlockPostDto().getFileBlockPostDto(), FileBlockPost.class);
                    dataBlockPostToSave.setFileBlockPostRelated(fileBlockPostToSave);
                }
                blockPostToSave.setDataBlockPost(dataBlockPostToSave);
            }

            return blockPostToSave;
        }).collect(Collectors.toList());

        this.blockPostService.saveManyBlockPost(blockPostListToSave);

        return this.modelMapper.map(postCreated, PostCreatedDto.class);
    }
}
