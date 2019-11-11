package com.sangkon.model.user;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

// 1. User 클래스의 객체는 builder()로 생성되어야 한다.
    @Test
    public void createPojoUserBuilder() {
        assertThat(User.builder().build()).isNotNull();
    }

// 2. POJO(Plain Old Java Object)의 첫 번째 특성인 기본 생성자
    @Test
    public void createPojoUserConstructor() {
        User user = new User();
        assertThat(user).isNotNull();
    }

// 3. POJO의 특성인 Setter/Getter
    @Test
    public void createPojoUserSetterGetter() {
        User user = User.builder().build();
        user.setBio("biobio");
        assertThat(user.getBio()).isEqualTo("biobio");
    }

// 4. POJO의 특성인 id(unique)
    @Test
    public void createPojoUserById() {
        User user = User.builder().id(1L).name("hello").build();
        User user2 = User.builder().id(1L).name("world").build();
        assertThat(user).isEqualTo(user2);
    }

    @Test
    public void createPojoUserByIdAndUsername(){
        User user = User.builder().id(1L).username("이름1").build();
        User user2 = User.builder().id(1L).username("이름2").phone("010").build();
        User user3 = User.builder().id(1L).username("이름2").phone("444").build();
        assertThat(user).isNotEqualTo(user2);
        assertThat(user2).isEqualTo(user3);
    }


}