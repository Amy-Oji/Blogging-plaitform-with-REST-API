package com.week9.week9_restapi_blogapp.controller;

import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class PostController {
    @PostMapping("/home_post")
    public String createPost(HttpSession httpSession, PostModel post) {
//        UserModel user = (UserModel) httpSession.getAttribute("logUser");
//        postService.addPost(user, post);
        return "redirect:/home";
    }
}
