package com.week9.week9_restapi_blogapp.controller;

import com.week9.week9_restapi_blogapp.dto.PostRequestDTO;
import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.service.PostService;
import com.week9.week9_restapi_blogapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
//    private final UserService userService;


    @PostMapping("/posts/{userId}")
    public ResponseEntity<PostModel> createPost(@RequestBody PostModel postModel, @PathVariable Long userId) {
        return new ResponseEntity<>(postService.addPost(userId, postModel), HttpStatus.OK);
    }
}