package com.ecram.usersmicroecram.posts.services;

import org.springframework.web.multipart.MultipartFile;


public interface ICloudinaryService {
    String uploadFileToCloudinary(MultipartFile multipartFile);
}
