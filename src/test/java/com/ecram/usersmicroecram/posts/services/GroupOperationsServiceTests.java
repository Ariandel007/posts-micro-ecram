package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.client.IUserClientRest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
    void testSaveFollowedGroup() {

    }
}
