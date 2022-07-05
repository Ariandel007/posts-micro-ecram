package com.ecram.usersmicroecram.posts.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class Group implements Serializable {
    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", nullable = true, length = 255)
    private String description;

    @Column(name = "logo_url", nullable = true, length = 255)
    private String logoUrl;

    @Column(name = "banner_url", nullable = true, length = 255)
    private String bannerUrl;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "create_date_utc", length = 255)
    private String createDateUtc;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @Column(name = "modify_date_utc", length = 255)
    private String modifyDateUtc;

    @OneToMany(mappedBy = "groupRelated", fetch = FetchType.LAZY)
    private List<FollowedGroup> followedGroupList;

    @OneToMany(mappedBy = "groupRelated", fetch = FetchType.LAZY)
    private List<Post> postList;

}
