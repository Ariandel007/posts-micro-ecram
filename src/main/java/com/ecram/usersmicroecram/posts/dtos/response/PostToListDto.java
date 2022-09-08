package com.ecram.usersmicroecram.posts.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostToListDto {
    private String id;
    private String name;
    private Long likeNumber;
    private Long dislikeNumber;
    private Instant createDate;
    private Long id_group;
}
