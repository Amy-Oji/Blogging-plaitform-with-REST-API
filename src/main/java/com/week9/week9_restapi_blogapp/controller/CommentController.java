package com.week9.week9_restapi_blogapp.controller;

import com.week9.week9_restapi_blogapp.model.CommentModel;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.service.CommentService;
import com.week9.week9_restapi_blogapp.service.PostService;
import com.week9.week9_restapi_blogapp.service.UserService;
import com.week9.week9_restapi_blogapp.serviceImplementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/blog")
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;
    private final UserService userService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService, UserService userService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
    }


    //commentController
    @PostMapping(path = "/createComment/{userId}/{postId}")
    public String createComment(@RequestBody CommentModel comment, @PathVariable Long userId, @PathVariable Long postId) {
        UserModel user = userService.getUserById(userId);
        if (user != null && commentService.makeComment(comment, userId, postId)) {
            String result = "Your Comment:'" + comment.getComment() + "' has been saved successfully!";
            return result;
        }
        return "Comment not saved";
    }
}