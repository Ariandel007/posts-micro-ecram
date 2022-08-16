package com.ecram.usersmicroecram.posts.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ecram.usersmicroecram.posts.data.DataToTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UploadToCloudServiceTests {

    @MockBean
    ICloudinaryService cloudinaryService;

    @Autowired
    IUploadToCloudService uploadToCloudService;

    @Test
    @DisplayName("Test - Subida de imagen a Cloudinary")
    void testUploadFileToCloudinary() throws IOException {
        //Given
        MockMultipartFile mockFile = DataToTest.getMockMultipartFile();
        Map<Object, Object> mapResult = new HashMap<>();
        mapResult.put("url", DataToTest.mockUrlCloudinary);
        when(this.cloudinaryService.uploadFileToCloudinary(any())).thenReturn(mapResult);

        //When
        String urlGenerated = this.uploadToCloudService.uploadFileToCloudinary(mockFile);

        //Then
        assertEquals(urlGenerated, DataToTest.mockUrlCloudinary);

    }


}
