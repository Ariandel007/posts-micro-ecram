package com.ecram.usersmicroecram.posts.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "file_block_posts")
public class FileBlockPost  implements Serializable {
    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", nullable = true)
    private String url;

//    @Column(name = "id_data_block_post", nullable = false)
//    private Long idDataBlockPost;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_data_block_post")//insertable=false, updatable=false si id_data_block_post esta siendo usado como el FK en el mapeo
    private DataBlockPost dataBlockPostRelated;
}
