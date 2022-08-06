package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.dtos.request.GroupToCreateDto;
import com.ecram.usersmicroecram.posts.models.Group;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface IGroupOperationsService {
    Group createGroup(String username, MultipartFile fileLogo, MultipartFile fileBanner, GroupToCreateDto group);
}
