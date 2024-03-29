package com.ecram.usersmicroecram.posts.controllers;

import com.ecram.usersmicroecram.posts.dtos.request.GroupToCreateDto;
import com.ecram.usersmicroecram.posts.models.Group;
import com.ecram.usersmicroecram.posts.services.IGroupOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("v1/groups")
public class GroupController {
    private final IGroupOperationsService groupOperationsService;

    @Autowired
    public GroupController(IGroupOperationsService groupOperationsService) {
        this.groupOperationsService = groupOperationsService;
    }

    @PostMapping(value = "/createGroup/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Group> createGroup(@RequestPart String name,
                                      @RequestPart String description,
                                      @RequestPart(value = "fileLogo", required = false) MultipartFile fileLogo,
                                      @RequestPart(value = "fileBanner", required = false) MultipartFile fileBanner,
                                      @PathVariable("userId") Long userId) {
        GroupToCreateDto groupToCreateDto = new GroupToCreateDto(name,description);
        Group groupCreated = this.groupOperationsService.createGroup(userId, fileLogo, fileBanner, groupToCreateDto);
        return ResponseEntity.ok().body(groupCreated);
    }

}
