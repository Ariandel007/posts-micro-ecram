package com.ecram.usersmicroecram.posts.data;

import com.ecram.usersmicroecram.posts.dtos.request.GroupToCreateDto;
import com.ecram.usersmicroecram.posts.models.Group;

import java.time.Instant;

public class DataToTest {

    public static Group getGroupToSave() {
        Group groupToSave = new Group();
        groupToSave.setId(null);
        groupToSave.setName("Grupo Testing");
        groupToSave.setDescription("Descripcion Test");
        groupToSave.setLogoUrl("/assets/default_url_logo.png");
        groupToSave.setBannerUrl("/assets/default_banner.png");
        groupToSave.setCreateDate(null);
        groupToSave.setCreateDateUtc(null);
        groupToSave.setModifyDate(null);
        groupToSave.setModifyDateUtc(null);

        return groupToSave;
    }

    public static GroupToCreateDto getGroupToCreateDto() {
        GroupToCreateDto group = new GroupToCreateDto();
        group.setName("Grupo Testing");
        group.setDescription("Descripcion Test");

        return group;
    }

    public static Group getGroupToRegisterWhenMultiPartIsNull() {
        Group groupToSave = new Group();
        groupToSave.setId(null);
        groupToSave.setName("Grupo Testing");
        groupToSave.setDescription("Descripcion Test");
        groupToSave.setLogoUrl(null);
        groupToSave.setBannerUrl(null);
        groupToSave.setCreateDate(null);
        groupToSave.setCreateDateUtc(null);
        groupToSave.setModifyDate(null);
        groupToSave.setModifyDateUtc(null);

        return groupToSave;
    }

    public static Group getGroupRegisteredWhenMultiPartIsNull() {
        Instant today = Instant.now();

        Group groupToSave = new Group();
        groupToSave.setId(1L);
        groupToSave.setName("Grupo Testing");
        groupToSave.setDescription("Descripcion Test");
        groupToSave.setLogoUrl("/assets/default_url_logo.png");
        groupToSave.setBannerUrl("/assets/default_banner.png");
        groupToSave.setCreateDate(today);
        groupToSave.setCreateDateUtc(today.toString());
        groupToSave.setModifyDate(today);
        groupToSave.setModifyDateUtc(today.toString());

        return groupToSave;
    }

}
