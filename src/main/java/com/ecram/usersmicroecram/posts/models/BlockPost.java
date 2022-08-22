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
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "block_posts_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "id_post", nullable = false)
    private Long idPost;

    //al insertar
    @OneToOne(mappedBy = "blockPostRelated", fetch = FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
    private DataBlockPost dataBlockPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post", insertable=false, updatable=false)//insertable=false, updatable=false porque id_post esta siendo usado como el FK
    private Post postRelated;

    public void setDataBlockPost(DataBlockPost dataBlockPost) {
        this.dataBlockPost = dataBlockPost;
        this.dataBlockPost.setBlockPostRelated(this);
    }
}
