package com.ecram.usersmicroecram.posts.controllers;

import com.ecram.usersmicroecram.posts.dtos.request.PostToCreateDto;
import com.ecram.usersmicroecram.posts.dtos.response.PostCreatedDto;
import com.ecram.usersmicroecram.posts.dtos.response.PostToListDto;
import com.ecram.usersmicroecram.posts.services.IPostOperationsService;
import com.ecram.usersmicroecram.posts.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/posts")
public class PostController {

    private final IPostOperationsService postOperationsService;
    private final IPostService postService;

    @Autowired
    public PostController(
            IPostOperationsService postOperationsService,
            IPostService postService) {
        this.postOperationsService = postOperationsService;
        this.postService = postService;
    }

    @PostMapping("/createPost/{userId}")
    ResponseEntity<PostCreatedDto> createPost(@RequestBody PostToCreateDto postToCreateDto,
                                              @PathVariable("userId") Long userId) {
        PostCreatedDto postCreatedDto = this.postOperationsService.createPost(userId, postToCreateDto);
        return ResponseEntity.ok().body(postCreatedDto);
    }

    @GetMapping("/public/listPostsInGroupInboxByGroup/{idGroup}/{cursor}")
    ResponseEntity<List<PostToListDto>> listPostsInGroupInboxByGroup(
            @PathVariable(value = "idGroup", required = true) Long idGroup,
            @PathVariable(value = "cursor", required = true) Long cursor
    ) {
        List<PostToListDto> listPostsInGroupInboxByGroup = this.postService.listPostsInGroupInboxByGroup(idGroup, cursor);
        return ResponseEntity.ok().body(listPostsInGroupInboxByGroup);
    }

}
