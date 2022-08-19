package com.ecram.usersmicroecram.posts.dtos.request;

import lombok.Data;

import java.util.List;

@Data
public class BlockPostToCreateDto {
    private Long id;
    private String type;
    private Long idPost;
    private List<DataBlockPostDto> dataBlockPostDtoList;

}
