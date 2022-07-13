package com.ecram.usersmicroecram.posts.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "posts")
public class Post implements Serializable {
    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "like_number", nullable = false)
    private Long likeNumber;

    @Column(name = "dislike_number", nullable = false)
    private Long dislikeNumber;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "status", nullable = false, length = 255)
    private String status;//enable, disabled, in_revision

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "create_date_utc", length = 255)
    private String createDateUtc;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @Column(name = "modify_date_utc", length = 255)
    private String modifyDateUtc;

    @Column(name = "id_group", nullable = false)
    private Long id_group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group", insertable=false, updatable=false)//insertable=false, updatable=false porque idUserApp esta siendo usado como el FK
    private Group groupRelated;

    @OneToMany(mappedBy = "postRelated", fetch = FetchType.LAZY)
    private List<Comment> commentList;

    @OneToMany(mappedBy = "postRelated", fetch = FetchType.LAZY)
    private List<BlockPost> blockPostList;
}
