package com.ecram.usersmicroecram.posts.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "followed_group")
public class FollowedGroup implements Serializable {
    private static final long serialVersionUID = 4002221912401133094L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "permision_group", nullable = true)
    private String permisionGroup;

    @Column(name = "id_user_app", nullable = false)
    private Long idUserApp;

    @Column(name = "id_group", nullable = false)
    private Long id_group;

}
