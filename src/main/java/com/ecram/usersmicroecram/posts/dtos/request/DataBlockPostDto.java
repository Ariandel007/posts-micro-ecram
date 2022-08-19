package com.ecram.usersmicroecram.posts.dtos.request;

import lombok.Data;

@Data
public class DataBlockPostDto {
    private String text;
    private Short level;
    private Short position;
    private String caption;
    private boolean withBorder = false;
    private boolean stretched = false;
    private boolean withBackground = false;
    private Long idBlockPost;
    private Long idFileBlockPost;
    private FileBlockPostDto fileBlockPostDto;
}
