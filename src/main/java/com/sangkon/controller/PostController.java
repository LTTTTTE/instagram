package com.sangkon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sangkon.model.post.Post;
import com.sangkon.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;
    private ObjectMapper objectMapper;

    public PostController(PostService postService, ObjectMapper objectMapper) {
        this.postService = postService;
        this.objectMapper = objectMapper;
    }

    //    @GetMapping("/user/{userId}")
//    @GetMapping("/images/{fileName:.+}")
//
    @GetMapping("/{postId}")
    public String getPost(@PathVariable Long postId) throws JsonProcessingException {
        Post post = postService.findPostById(postId);
        return objectMapper.writeValueAsString(post);
    }

//    @GetMapping("/{postId}/comments")
//    @GetMapping("/{postId}/comments/{commentId}")
//    @PostMapping("/{postId}/comments")
//    @PostMapping("{postId}/like")
//    @GetMapping("/{postId}/like")
//    @GetMapping("{postId}/like/exists")
//    @GetMapping("{postId}/like/count")
//    @PostMapping("{postId}/save")
//    @GetMapping("{postId}/save/exists")
//    @GetMapping("{postId}/modal")
}
