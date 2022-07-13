package com.ecram.usersmicroecram.posts.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "comments")
public class Comment implements Serializable {
    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_user", nullable = false)
    private String idUser;

    @Column(name = "like_number", nullable = false)
    private Long likeNumber;

    @Column(name = "dislike_number", nullable = false)
    private Long dislikeNumber;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "create_date_utc", length = 255)
    private String createDateUtc;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @Column(name = "modify_date_utc", length = 255)
    private String modifyDateUtc;

    @Column(name = "id_comment", nullable = true)
    private String idComment;

    @Column(name = "id_post", nullable = false)
    private String idPost;

    @Lob
    @Column(name = "content_comment", nullable = false)
    private String contentComment;

    //recursivo porque id_comment referencia a un Comment padre, por eso usamos el referencedColumnName = "id"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comment", insertable=false, updatable=false, referencedColumnName = "id")//insertable=false, updatable=false porque idUserApp esta siendo usado como el FK
    @JsonBackReference
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post", insertable=false, updatable=false)//insertable=false, updatable=false porque idUserApp esta siendo usado como el FK
    private Post postRelated;

}
