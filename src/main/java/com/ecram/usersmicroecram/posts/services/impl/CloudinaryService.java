package com.ecram.usersmicroecram.posts.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ecram.usersmicroecram.posts.exceptions.ErrorUploadToCloudinary;
import com.ecram.usersmicroecram.posts.services.ICloudinaryService;
import com.ecram.usersmicroecram.posts.utils.MessageErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
public class CloudinaryService implements ICloudinaryService {
    private final Cloudinary cloudinaryConfig;

    @Autowired
    public CloudinaryService(Cloudinary cloudinaryConfig) {
        this.cloudinaryConfig = cloudinaryConfig;
    }

    @Override
    public Map uploadFileToCloudinary(File fileToUpload) {
        try {
            return this.cloudinaryConfig.uploader().upload(fileToUpload, ObjectUtils.emptyMap());
        } catch (Exception e) {
            throw new ErrorUploadToCloudinary(MessageErrors.ERROR_FILE_UPLOAD_MSG, MessageErrors.ERROR_FILE_UPLOAD_CODE);
        }
    }
}
