package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.client.IUserClientRest;
import com.ecram.usersmicroecram.posts.data.DataToTest;
import com.ecram.usersmicroecram.posts.dtos.request.BlockPostToCreateDto;
import com.ecram.usersmicroecram.posts.dtos.request.DataBlockPostDto;
import com.ecram.usersmicroecram.posts.dtos.request.FileBlockPostDto;
import com.ecram.usersmicroecram.posts.dtos.request.PostToCreateDto;
import com.ecram.usersmicroecram.posts.dtos.response.PostCreatedDto;
import com.ecram.usersmicroecram.posts.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PostOperationsServiceTests {

    @MockBean
    IPostService postService;

    @MockBean
    IBlockPostService blockPostService;

    @MockBean
    IUserClientRest userClientRest;

    @MockBean
    ModelMapper modelMapper;

    @Autowired
    IPostOperationsService postOperationsService;


    @Test
    @DisplayName("Test - Registro de un nuevo Post")
    void testRegisterANewPost() {

        //Given
        PostToCreateDto postToCreateDto = DataToTest.postToCreateDto();
        Post postToSave = DataToTest.postToSave();
        BlockPostToCreateDto blockPostToCreateDto = postToCreateDto.getBlockPostToCreateDtoList().get(0);
        DataBlockPostDto dataBlockPostDto = blockPostToCreateDto.getDataBlockPostDto();
        FileBlockPostDto fileBlockPostDto = dataBlockPostDto.getFileBlockPostDto();
        BlockPost blockPost = DataToTest.blockPostToSave();
        DataBlockPost dataBlockPost = DataToTest.dataBlockPost();
        FileBlockPost fileBlockPost = DataToTest.fileBlockPost();
        PostCreatedDto postCreatedDto = DataToTest.postCreatedDto();

        when(this.userClientRest.getUserIdByUsername(any())).thenReturn(ResponseEntity.ok().body(2L));
        when(this.modelMapper.map(postToCreateDto, Post.class)).thenReturn(postToSave);
        when(this.postService.savePost(any())).thenReturn(postToSave);
        when(this.modelMapper.map(blockPostToCreateDto, BlockPost.class)).thenReturn(blockPost);
        when(this.modelMapper.map(dataBlockPostDto, DataBlockPost.class)).thenReturn(dataBlockPost);
        when(this.modelMapper.map(fileBlockPostDto, FileBlockPost.class)).thenReturn(fileBlockPost);
        when(this.blockPostService.saveManyBlockPost(any())).thenReturn(new ArrayList<BlockPost>());
        when(this.modelMapper.map(postToSave, PostCreatedDto.class)).thenReturn(postCreatedDto);

        //When
        PostCreatedDto postCreatedDtoInService = this.postOperationsService.createPost("usertest",postToCreateDto);

        //Then
        assertEquals(postCreatedDtoInService,postCreatedDto);

    }

}
