package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.models.FollowedGroup;
import com.ecram.usersmicroecram.posts.repositories.IFollowedGroupRepository;
import com.ecram.usersmicroecram.posts.utils.PermissionGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FollowedGroupServiceTests {

    @MockBean
    IFollowedGroupRepository followedGroupRepository;

    @Autowired
    IFollowedGroupService followedGroupService;

    @Test
    @DisplayName("Test - Guardar FollowedGroup")
    void testSaveFollowedGroup() {
        when(this.followedGroupRepository.save(any())).then(invocation -> {
            FollowedGroup followedGroup = invocation.getArgument(0);
            followedGroup.setId(1L);
            return followedGroup;
        });

        //Given
        Long idUser = 21L;
        Long idGroup = 23L;
        String permissionGroup = PermissionGroup.SUPER_GROUP_ADMIN.toString();

        //When
        Instant beforeSave = Instant.now();

        FollowedGroup savedFollowedGroup = followedGroupService.saveFollowedGroup(idUser, idGroup, permissionGroup);

        Instant afterSave = Instant.now();

        //Then

        assertEquals(idUser, savedFollowedGroup.getIdUserApp());
        assertEquals(idGroup, savedFollowedGroup.getId_group());
        assertEquals(permissionGroup, savedFollowedGroup.getPermisionGroup());

        //if s1 > s2, it returns positive number
        //if s1 < s2, it returns negative number
        //if s1 == s2, it returns 0
        assertTrue(savedFollowedGroup.getCreateDate().compareTo(beforeSave) >= 0);
        assertTrue(savedFollowedGroup.getCreateDate().compareTo(afterSave) <= 0);

        assertEquals(savedFollowedGroup.getCreateDate().toString(), savedFollowedGroup.getCreateDateUtc());
        assertEquals(savedFollowedGroup.getModifyDate().toString(), savedFollowedGroup.getModifyDateUtc());

    }

}
