package com.ecram.usersmicroecram.posts.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

public interface ICloudinaryService {
    Map uploadFileToCloudinary(File fileToUpload);
}
