package com.week9.week9_restapi_blogapp.controller;

import com.week9.week9_restapi_blogapp.dto.PostRequestDTO;
import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.service.PostService;
import com.week9.week9_restapi_blogapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
public class PostController {
    private final PostService postService;
    private final UserService userService;
    @Autowired

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }




//
    @PostMapping("/posts/{id}")
    public ResponseEntity<PostModel> createPost(@PathVariable(name = "id") Long userId, @RequestBody PostModel post) { // Httpsession
        UserModel userModel = userService.getUserById(userId); //getAuthorById(authorId);
        System.out.println(userModel);
         if (userModel != null) {
        postService.addPost(userModel, post);
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/viewallposts")
    public ResponseEntity<List> viewAllPosts() {
        List<PostModel> listOfPosts = postService.viewAllPosts();
        return new ResponseEntity<>(listOfPosts, HttpStatus.OK);
    }
    @GetMapping("/viewposts/{id}")
    public ResponseEntity<List> viewPostsByUser(@PathVariable(name = "id") Long userId) {
        UserModel user = userService.getUserById(userId);
        List<PostModel> listOfAuthorPosts = postService.getPostsByUser(user);
        return new ResponseEntity<>(listOfAuthorPosts, HttpStatus.OK);
    }

    @PostMapping("/addPostToFavourite/{user_id}/{post_id}")
    public String addPostToFavourite(@PathVariable Long post_id, @PathVariable Long user_id){
        postService.addPostToFavouriteList(user_id,post_id);
        return "Post added to favourite";
    }
    @GetMapping("/listOfFavouritePosts{user_id}")
    public List<PostModel> getFavouritePosts(Long userId) {
        return postService.getListOfFavPosts(userId);
    }

    @PostMapping("/likePost/{user_id}/{post_id}")
    public String likePost(@PathVariable Long user_id, @PathVariable Long post_id){
        postService.addLikes(user_id, post_id);
        return "Post has been liked";
    }

    @GetMapping("/getPostlikes{post_id}")
    public Integer getPostLikes(@PathVariable Long post_id) {
        return postService.getLike(post_id);
    }
}