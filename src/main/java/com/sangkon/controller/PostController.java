package com.sangkon.controller;


import com.sangkon.model.post.Post;
import com.sangkon.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //    @GetMapping("/user/{userId}")
//    @GetMapping("/images/{fileName:.+}")
//
    @GetMapping("/{postId}")
    public String getPost(@PathVariable Long postId){
        Post postById = postService.findPostById(postId);
        return postById.getDescription();
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
