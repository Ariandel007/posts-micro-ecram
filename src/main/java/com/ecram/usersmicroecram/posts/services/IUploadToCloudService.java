package com.ecram.usersmicroecram.posts.services;

import org.springframework.web.multipart.MultipartFile;


public interface IUploadToCloudService {
    String uploadFileToCloudinary(MultipartFile multipartFile);
}
