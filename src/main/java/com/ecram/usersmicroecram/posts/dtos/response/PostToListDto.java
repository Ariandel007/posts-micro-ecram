package com.ecram.usersmicroecram.posts.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostToListDto {
    private Long id;
    private String name;
    private Long likeNumber;
    private Long dislikeNumber;
    private Instant createDate;
    private Long id_group;
}
