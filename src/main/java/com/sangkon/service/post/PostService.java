package com.sangkon.service.post;

import com.sangkon.model.post.Post;
import com.sangkon.repository.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findPostById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> findAllPost(){
        return postRepository.findAll();
    }
}
