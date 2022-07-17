package com.ecram.usersmicroecram.posts.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "block_posts")
public class BlockPost implements Serializable {
    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "id_post", nullable = false)
    private Long idPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post", insertable=false, updatable=false)//insertable=false, updatable=false porque idUserApp esta siendo usado como el FK
    private Post postRelated;
}
