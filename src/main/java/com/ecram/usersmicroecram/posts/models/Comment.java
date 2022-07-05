package com.ecram.usersmicroecram.posts.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "id_post", nullable = false)
    private String idPost;

    @Column(name = "id_comment", nullable = false)
    private String idComment;

    @Lob
    @Column(name = "body", nullable = false)
    private String body;
}
