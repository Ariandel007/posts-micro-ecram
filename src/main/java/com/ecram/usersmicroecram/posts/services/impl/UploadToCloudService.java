package com.ecram.usersmicroecram.posts.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ecram.usersmicroecram.posts.exceptions.ErrorConvertMultiPart;
import com.ecram.usersmicroecram.posts.services.ICloudinaryService;
import com.ecram.usersmicroecram.posts.services.IUploadToCloudService;
import com.ecram.usersmicroecram.posts.utils.MessageErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class UploadToCloudService implements IUploadToCloudService {

    private final ICloudinaryService cloudinaryService;

    @Autowired
    public UploadToCloudService(ICloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public String uploadFileToCloudinary(MultipartFile multipartFile) {
        try {
            File uploadedFile = convertMultiPartToFile(multipartFile);
            Map uploadResult = cloudinaryService.uploadFileToCloudinary(uploadedFile);
            boolean isDeleted = uploadedFile.delete();

            if (isDeleted){
                System.out.println("Se elimino el archivo satisfactoriamente");
            }else
                System.out.println("El archivo no existe");
            return uploadResult.get("url").toString();
        } catch (Exception e) {
            throw new ErrorConvertMultiPart(MessageErrors.ERROR_FILE_CONVERTER_MSG, MessageErrors.ERROR_FILE_CONVERTER_CODE);
        }
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
