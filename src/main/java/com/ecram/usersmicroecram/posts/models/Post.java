package com.ecram.usersmicroecram.posts.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "posts")
public class Post implements Serializable {
    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "like_number", nullable = false)
    private Long likeNumber;

    @Column(name = "dislike_number", nullable = false)
    private Long dislikeNumber;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "status", nullable = false)
    private String status;//enable, disabled, in_revision

    @Lob
    @Column(name = "body", nullable = false)
    private String body;
}
