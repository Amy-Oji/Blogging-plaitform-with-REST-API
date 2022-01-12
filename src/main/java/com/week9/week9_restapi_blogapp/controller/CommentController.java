package com.week9.week9_restapi_blogapp.controller;

import com.week9.week9_restapi_blogapp.model.CommentModel;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.service.CommentService;
import com.week9.week9_restapi_blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


//    private final UserService userService;


    @PostMapping("/comments/{userId}/{postId}")
    public ResponseEntity<CommentModel> createComment(@RequestBody CommentModel commentModel, @PathVariable Long userId, @PathVariable Long postId ) {
        return new ResponseEntity<>(commentService.makeComment(userId, postId,  commentModel), HttpStatus.OK);
    }

}
