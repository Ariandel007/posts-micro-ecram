package com.ecram.usersmicroecram.posts.services.impl;

import com.ecram.usersmicroecram.posts.client.IUserClientRest;
import com.ecram.usersmicroecram.posts.dtos.request.GroupToCreateDto;
import com.ecram.usersmicroecram.posts.models.Group;
import com.ecram.usersmicroecram.posts.services.IUploadToCloudService;
import com.ecram.usersmicroecram.posts.services.IFollowedGroupService;
import com.ecram.usersmicroecram.posts.services.IGroupOperationsService;
import com.ecram.usersmicroecram.posts.services.IGroupService;
import com.ecram.usersmicroecram.posts.utils.PermissionGroup;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GroupOperationsService implements IGroupOperationsService {

    private final IUploadToCloudService uploadToCloudService;
    private final IGroupService groupService;
    private final IUserClientRest userClientRest;
    private final IFollowedGroupService followedGroupService;
    private final ModelMapper modelMapper;

    @Autowired
    public GroupOperationsService(IUploadToCloudService uploadToCloudService,
                                  IGroupService groupService,
                                  IUserClientRest userClientRest,
                                  IFollowedGroupService followedGroupService,
                                  ModelMapper modelMapper) {
        this.uploadToCloudService = uploadToCloudService;
        this.groupService = groupService;
        this.userClientRest = userClientRest;
        this.followedGroupService = followedGroupService;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = false)
    public Group createGroup(Long userId, MultipartFile fileLogo, MultipartFile fileBanner, GroupToCreateDto group) {
//        Long userId = this.userClientRest.getUserIdByUsername(username).getBody();
        String urlFileLogo = "/assets/default_url_logo.png";
        String urlFileBanner = "/assets/default_banner.png";
        if(fileLogo != null) {
            urlFileLogo = this.uploadToCloudService.uploadFileToCloudinary(fileLogo);
        }
        if(fileBanner != null) {
            urlFileBanner = this.uploadToCloudService.uploadFileToCloudinary(fileBanner);
        }
        Group groupToSave = this.modelMapper.map(group, Group.class);
        groupToSave.setLogoUrl(urlFileLogo);
        groupToSave.setBannerUrl(urlFileBanner);

        Group groupSaved = this.groupService.saveGroup(groupToSave);

        this.followedGroupService.saveFollowedGroup(userId, groupSaved.getId(), PermissionGroup.SUPER_GROUP_ADMIN.toString());

        return groupSaved;
    }
}
