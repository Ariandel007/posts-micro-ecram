package com.ecram.usersmicroecram.posts.dtos.request;

import lombok.Data;

@Data
public class BlockPostToCreateDto {
    private String type;
    private Long idPost;
    private DataBlockPostDto dataBlockPostDto;

}
