package com.sangkon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sangkon.model.user.User;
import com.sangkon.service.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;
    private ObjectMapper objectMapper;

    public UserController(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    //    @GetMapping("/me")
//    @GetMapping("/checkUsernameAvailability")
//    @GetMapping("/user/checkEmailAvailability")
//    @GetMapping("{username}")
//    @GetMapping("/search/{usernameOrName}")
    @GetMapping("/profile/{username}")
    public String getUser(@PathVariable String username) throws JsonProcessingException {
        User userByUsername = userService.findUserByUsername(username);
        return objectMapper.writeValueAsString(userByUsername);
    }
//    @GetMapping("/profile/edit")
//    @PutMapping("/profile/edit")
//    @PostMapping("/profile/photo")
//    @DeleteMapping("/profile/photo")
//    @PutMapping("/me/private")
}
