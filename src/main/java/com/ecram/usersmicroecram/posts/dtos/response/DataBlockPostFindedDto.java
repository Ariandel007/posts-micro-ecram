package com.ecram.usersmicroecram.posts.dtos.response;

import com.ecram.usersmicroecram.posts.models.FileBlockPost;
import lombok.Data;

@Data
public class DataBlockPostFindedDto {
    private Long id;
    private String text;
    private Short level;
    private Short position;
    private String caption;
    private boolean withBorder = false;
    private boolean stretched = false;
    private boolean withBackground = false;
    private FileBlockPostFindedDto fileBlockPostRelated;
}
