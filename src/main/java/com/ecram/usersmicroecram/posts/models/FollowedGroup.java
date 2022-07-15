package com.ecram.usersmicroecram.posts.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "followed_group")
public class FollowedGroup implements Serializable {
    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "permision_group", nullable = true, length = 255)
    private String permisionGroup;

    @Column(name = "id_user_app", nullable = false)
    private Long idUserApp;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "create_date_utc", length = 255)
    private String createDateUtc;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @Column(name = "modify_date_utc", length = 255)
    private String modifyDateUtc;

    @Column(name = "id_group", nullable = true)
    private Long id_group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group", insertable=false, updatable=false)//insertable=false, updatable=false porque idUserApp esta siendo usado como el FK
    private Group groupRelated;

}
