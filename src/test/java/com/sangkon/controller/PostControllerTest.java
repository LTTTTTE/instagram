package com.sangkon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sangkon.model.post.Post;
import com.sangkon.repository.post.PostRepository;
import com.sangkon.service.post.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    PostService postService;


    @Before
    public void saveData(){
        postService.savePost(Post.builder().id(1L).description("Desc").build());
        postService.savePost(Post.builder().id(2L).description("내용").build());
        postService.savePost(Post.builder().id(3L).imagePath("C").build());
    }

    @Test
    public void testGetPost() throws Exception {
        mockMvc.perform(get("/api/posts/1").contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON))
                .andExpect(jsonPath("description").exists());
        mockMvc.perform(get("/api/posts/2").contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON))
                .andExpect(jsonPath("description", "내용").exists());
    }
}