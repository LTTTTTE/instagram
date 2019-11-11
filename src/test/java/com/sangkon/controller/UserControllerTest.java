package com.sangkon.controller;

import com.sangkon.model.user.User;
import com.sangkon.service.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Before
    public void initData(){
        userService.saveUser(User.builder()
                .id(1L)
                .username("ksu")
                .email("ks@ks.ac.kr")
                .phone("051-663-1234")
                .build());
    }

    @Test
    public void testGetUser() throws Exception {
        mockMvc.perform(get("/api/users/profile/ksu")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON))
                .andExpect(jsonPath("username").exists())
                .andExpect(jsonPath("email").value("ks@ks.ac.kr"))
                .andExpect(jsonPath("phone").value("051-663-1234"));
    }
}