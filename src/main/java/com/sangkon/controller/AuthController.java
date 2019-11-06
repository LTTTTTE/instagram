package com.sangkon.controller;

import com.sangkon.model.user.User;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
//    @PostMapping("/signin")
    @PostMapping("/signup")
    public ResponseEntity singup(@RequestBody User user){
        URI createUri = linkTo(methodOn(AuthController.class).singup(user)).toUri();
        return ResponseEntity.created(createUri).body(user);
    }
//    @PostMapping("/password/change")
}
