package com.sangkon.model.post;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTest {

    @Test
    public void createPojoPostBuilder(){
        assertThat(Post.builder().build()).isNotNull();
    }

    @Test
    public void createPojoPostConstructor(){
        assertThat(new Post()).isNotNull();
    }

    @Test
    public void createPojoPostGetterSetter(){
        Post build = Post.builder().build();
        build.setDescription("내용");
        assertThat(build.getDescription()).isEqualTo("내용");
    }

    @Test
    public void createPojoPostById(){
        Post post1 = Post.builder().id(1L).description("내용1").build();
        Post post2 = Post.builder().id(1L).description("내용2").build();
        assertThat(post1).isEqualTo(post2);

    }

}