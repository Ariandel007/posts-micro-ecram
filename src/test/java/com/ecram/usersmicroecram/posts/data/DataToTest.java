package com.ecram.usersmicroecram.posts.data;

import com.ecram.usersmicroecram.posts.models.Group;

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
}
