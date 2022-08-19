package com.ecram.usersmicroecram.posts.dtos.request;

import lombok.Data;

import java.util.List;

@Data
public class PostToCreateDto {

    private String name;
    private Long idUser;
    private Long id_group;
    private List<BlockPostToCreateDto> blockPostToCreateDtoList;

}
