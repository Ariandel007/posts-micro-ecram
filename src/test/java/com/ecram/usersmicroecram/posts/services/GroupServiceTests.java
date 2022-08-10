package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.data.DataToTest;
import com.ecram.usersmicroecram.posts.models.FollowedGroup;
import com.ecram.usersmicroecram.posts.models.Group;
import com.ecram.usersmicroecram.posts.repositories.IGroupRepository;
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
public class GroupServiceTests {

    @MockBean
    IGroupRepository groupRepository;

    @Autowired
    IGroupService groupService;

    @Test
    @DisplayName("Test - Guardar Group")
    void testSaveGroup() {
        when(this.groupRepository.save(any())).then(invocation -> {
            Group group = invocation.getArgument(0);
            group.setId(1L);
            return group;
        });

        //When
        Group groupToSave = DataToTest.getGroupToSave();
        Instant beforeSave = Instant.now();
        Group savedGroup = this.groupService.saveGroup(groupToSave);
        Instant afterSave = Instant.now();

        //Then
        assertTrue(savedGroup.getCreateDate().compareTo(beforeSave) >= 0);
        assertTrue(savedGroup.getCreateDate().compareTo(afterSave) <= 0);

        assertEquals(savedGroup.getCreateDate().toString(), savedGroup.getCreateDateUtc());
        assertEquals(savedGroup.getModifyDate().toString(), savedGroup.getModifyDateUtc());

    }


}
