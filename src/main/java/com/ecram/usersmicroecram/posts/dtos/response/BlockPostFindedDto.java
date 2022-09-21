package com.ecram.usersmicroecram.posts.dtos.response;

import lombok.Data;

@Data
public class BlockPostFindedDto {
    private Long id;
    private String type;
    private Long idPost;
    private DataBlockPostFindedDto dataBlockPost;
}
