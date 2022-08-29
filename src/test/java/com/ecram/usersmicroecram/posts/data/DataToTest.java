package com.ecram.usersmicroecram.posts.data;

import com.ecram.usersmicroecram.posts.dtos.request.*;
import com.ecram.usersmicroecram.posts.dtos.response.PostCreatedDto;
import com.ecram.usersmicroecram.posts.models.*;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DataToTest {

    public static Group getGroupToSave() {
        Group groupToSave = new Group();
        groupToSave.setId(null);
        groupToSave.setName("Grupo Testing");
        groupToSave.setDescription("Descripcion Test");
        groupToSave.setLogoUrl("/assets/default_url_logo.png");
        groupToSave.setBannerUrl("/assets/default_banner.png");
        groupToSave.setCreateDate(null);
        groupToSave.setCreateDateUtc(null);
        groupToSave.setModifyDate(null);
        groupToSave.setModifyDateUtc(null);

        return groupToSave;
    }

    public static GroupToCreateDto getGroupToCreateDto() {
        GroupToCreateDto group = new GroupToCreateDto();
        group.setName("Grupo Testing");
        group.setDescription("Descripcion Test");

        return group;
    }

    public static Group getGroupToRegisterWhenMultiPartIsNull() {
        Group groupToSave = new Group();
        groupToSave.setId(null);
        groupToSave.setName("Grupo Testing");
        groupToSave.setDescription("Descripcion Test");
        groupToSave.setLogoUrl(null);
        groupToSave.setBannerUrl(null);
        groupToSave.setCreateDate(null);
        groupToSave.setCreateDateUtc(null);
        groupToSave.setModifyDate(null);
        groupToSave.setModifyDateUtc(null);

        return groupToSave;
    }

    public static Group getGroupRegisteredWhenMultiPartIsNull() {
        Instant today = Instant.now();

        Group groupToSave = new Group();
        groupToSave.setId(1L);
        groupToSave.setName("Grupo Testing");
        groupToSave.setDescription("Descripcion Test");
        groupToSave.setLogoUrl("/assets/default_url_logo.png");
        groupToSave.setBannerUrl("/assets/default_banner.png");
        groupToSave.setCreateDate(today);
        groupToSave.setCreateDateUtc(today.toString());
        groupToSave.setModifyDate(today);
        groupToSave.setModifyDateUtc(today.toString());

        return groupToSave;
    }

    public static MockMultipartFile getMockMultipartFile() throws IOException {
        File uploadFile = new File("src/test/resources/static/file.jpeg");
        FileInputStream imageFile =  new FileInputStream(uploadFile);

        return new MockMultipartFile(
                "file.jpeg",
                "file.jpeg",
                MediaType.IMAGE_JPEG_VALUE,
                imageFile
        );
    }

    public static String mockUrlCloudinary = "/cloudinary.com/hashimage";

    public static PostToCreateDto postToCreateDto() {
        PostToCreateDto postToCreateDto = new PostToCreateDto();
        BlockPostToCreateDto blockPostToCreateDto = new BlockPostToCreateDto();
        DataBlockPostDto dataBlockPostDto = new DataBlockPostDto();

        FileBlockPostDto fileBlockPostDto = new FileBlockPostDto();
        fileBlockPostDto.setUrl("https://codex.so/public/app/img/external/codex2x.png");

        dataBlockPostDto.setCaption("");
        dataBlockPostDto.setWithBackground(false);
        dataBlockPostDto.setWithBorder(false);
        dataBlockPostDto.setFileBlockPostDto(fileBlockPostDto);


        blockPostToCreateDto.setType("image");
        blockPostToCreateDto.setDataBlockPostDto(dataBlockPostDto);

        postToCreateDto.setName("Alexander");
        postToCreateDto.setIdUser(2L);
        postToCreateDto.setId_group(1L);
        List<BlockPostToCreateDto> blockPostToCreateDtoList = new ArrayList<>();
        blockPostToCreateDtoList.add(blockPostToCreateDto);
        postToCreateDto.setBlockPostToCreateDtoList(blockPostToCreateDtoList);

        return postToCreateDto;

    }

    public static Post postToSave() {
        Post post = new Post();
        post.setName("Alexander Post");
        post.setIdUser(2L);
        post.setId_group(1L);
        return post;
    }

    public static BlockPost blockPostToSave() {
        BlockPost blockPost = new BlockPost();
        blockPost.setType("image");
        return blockPost;
    }

    public static DataBlockPost dataBlockPost() {
        DataBlockPost dataBlockPost = new DataBlockPost();
        dataBlockPost.setCaption("");
        dataBlockPost.setWithBackground(false);
        dataBlockPost.setWithBorder(false);
        return dataBlockPost;
    }

    public static FileBlockPost fileBlockPost() {
        FileBlockPost fileBlockPost = new FileBlockPost();
        fileBlockPost.setUrl("https://codex.so/public/app/img/external/codex2x.png");
        return fileBlockPost;
    }

    public static PostCreatedDto postCreatedDto() {
        PostCreatedDto postCreatedDto = new PostCreatedDto();
        postCreatedDto.setName("Alexander Post");
        postCreatedDto.setId_group(1L);
        postCreatedDto.setIdUser(2L);
        return postCreatedDto;
    }

}
