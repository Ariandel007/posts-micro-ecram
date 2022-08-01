package com.ecram.usersmicroecram.posts.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ICloudinaryService {
    String uploadFileToCloudinary(MultipartFile multipartFile);
}
