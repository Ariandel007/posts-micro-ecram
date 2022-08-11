package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.client.IUserClientRest;
import com.ecram.usersmicroecram.posts.data.DataToTest;
import com.ecram.usersmicroecram.posts.dtos.request.GroupToCreateDto;
import com.ecram.usersmicroecram.posts.models.Group;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GroupOperationsServiceTests {

    @MockBean
    ICloudinaryService cloudinaryService;

    @MockBean
    IGroupService groupService;

    @MockBean
    IUserClientRest userClientRest;

    @MockBean
    IFollowedGroupService followedGroupService;

    @MockBean
    ModelMapper modelMapper;

    @Autowired
    IGroupOperationsService groupOperationsService;


    @Test
    @DisplayName("Test - Registro de un Grupo (Group Operations)")
    void testRegisterANewGroupWhenMultiPartIsNull() {
        //Given

        GroupToCreateDto group = DataToTest.getGroupToCreateDto();
        Group groupToSave = DataToTest.getGroupToRegisterWhenMultiPartIsNull();
        Group groupSaved = DataToTest.getGroupRegisteredWhenMultiPartIsNull();
        when(this.userClientRest.getUserIdByUsername(any())).thenReturn(ResponseEntity.ok().body(2L));
        when(this.cloudinaryService.uploadFileToCloudinary(any())).thenReturn("/cloudinary.com/hashimage");
        when(this.modelMapper.map(group, Group.class)).thenReturn(groupToSave);
        when(this.groupService.saveGroup(any())).thenReturn(groupSaved);
        when(this.followedGroupService.saveFollowedGroup(any(), any(), any())).thenReturn(null);

        String username = "testusername";

        //When
        Group groupGenerated = this.groupOperationsService.createGroup(username, null, null, group);

        //Then
        assertEquals(groupGenerated,groupSaved);

    }
}
