package com.ecram.usersmicroecram.posts.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "data_block_posts")
public class DataBlockPost implements Serializable {
    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "level", nullable = false)
    private Short level;

    @Column(name = "position", nullable = true)
    private Short position;

    @Column(name = "caption", nullable = true, length = 255)
    private String caption;

    @Column(name = "with_border", nullable = false)
    private boolean withBorder = false;

    @Column(name = "stretched", nullable = false)
    private boolean stretched = false;

    @Column(name = "with_background", nullable = false)
    private boolean withBackground = false;

    @Column(name = "id_block_posts", nullable = false)
    private String idBlockPost;

    @Column(name = "id_file_block_posts", nullable = true)
    private String idFileBlockPost;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_block_posts", insertable=false, updatable=false)//insertable=false, updatable=false porque idUserApp esta siendo usado como el FK
    private BlockPost blockPostRelated;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_file_block_posts", insertable=false, updatable=false)//insertable=false, updatable=false porque idUserApp esta siendo usado como el FK
    private FileBlockPost fileBlockPostRelated;

}
