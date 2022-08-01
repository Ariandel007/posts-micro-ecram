package com.ecram.usersmicroecram.posts.dtos.request;

import com.ecram.usersmicroecram.posts.models.FollowedGroup;
import com.ecram.usersmicroecram.posts.models.Post;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
public class GroupToCreateDto {

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", nullable = true, length = 255)
    private String description;

    @Column(name = "logo_url", nullable = true, length = 255)
    private String logoUrl;

    @Column(name = "banner_url", nullable = true, length = 255)
    private String bannerUrl;

}
