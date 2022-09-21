package com.ecram.usersmicroecram.posts.dtos.response;

import com.ecram.usersmicroecram.posts.models.BlockPost;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
public class PostFindedDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long likeNumber;

    private Long dislikeNumber;

    private Long idUser;

    private String status;

    private Instant createDate;

    private String createDateUtc;

    private Instant modifyDate;

    private String modifyDateUtc;

    private Long id_group;

    private List<BlockPostFindedDto> blockPostList;
}
