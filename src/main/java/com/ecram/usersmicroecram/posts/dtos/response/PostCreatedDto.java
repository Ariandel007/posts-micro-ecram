package com.ecram.usersmicroecram.posts.dtos.response;

import lombok.Data;

@Data
public class PostCreatedDto {
    private String name;
    private Long idUser;
    private Long id_group;
}
