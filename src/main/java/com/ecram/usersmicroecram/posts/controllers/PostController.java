package com.ecram.usersmicroecram.posts.controllers;

import com.ecram.usersmicroecram.posts.dtos.request.PostToCreateDto;
import com.ecram.usersmicroecram.posts.dtos.response.PostCreatedDto;
import com.ecram.usersmicroecram.posts.services.IPostOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/posts")
public class PostController {

    private final IPostOperationsService postOperationsService;

    @Autowired
    public PostController(IPostOperationsService postOperationsService) {
        this.postOperationsService = postOperationsService;
    }

    @PostMapping("/createPost/{username}")
    ResponseEntity<PostCreatedDto> createPost(@RequestBody PostToCreateDto postToCreateDto,
                                              @PathVariable("username") String username) {
        PostCreatedDto postCreatedDto = this.postOperationsService.createPost(username, postToCreateDto);
        return ResponseEntity.ok().body(postCreatedDto);
    }

}
