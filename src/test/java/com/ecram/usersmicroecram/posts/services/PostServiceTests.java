package com.ecram.usersmicroecram.posts.services;

import com.ecram.usersmicroecram.posts.data.DataToTest;
import com.ecram.usersmicroecram.posts.models.FollowedGroup;
import com.ecram.usersmicroecram.posts.models.Post;
import com.ecram.usersmicroecram.posts.repositories.IFollowedGroupRepository;
import com.ecram.usersmicroecram.posts.repositories.IPostRepository;
import com.ecram.usersmicroecram.posts.utils.PostStates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostServiceTests {

    @MockBean
    IPostRepository postRepository;

    @Autowired
    IPostService postService;

    @Test
    @DisplayName("Test - Guardar Post")
    void testSavePost() {
        when(this.postRepository.save(any())).then(invocation -> {
            Post post = invocation.getArgument(0);
            post.setId(1L);
            return post;
        });
        //Given
        Post postToSave = DataToTest.postToSave();

        //When
        Instant beforeSave = Instant.now();

        Post saved = this.postService.savePost(postToSave);

        Instant afterSave = Instant.now();

        //Then

        assertEquals(PostStates.enable.toString(), saved.getStatus());
        assertEquals(0L, saved.getLikeNumber());
        assertEquals(0L, saved.getDislikeNumber());

        //if s1 > s2, it returns positive number
        //if s1 < s2, it returns negative number
        //if s1 == s2, it returns 0
        assertTrue(saved.getCreateDate().compareTo(beforeSave) >= 0);
        assertTrue(saved.getCreateDate().compareTo(afterSave) <= 0);

        assertEquals(saved.getCreateDate().toString(), saved.getCreateDateUtc());
        assertEquals(saved.getModifyDate().toString(), saved.getModifyDateUtc());


    }
}
