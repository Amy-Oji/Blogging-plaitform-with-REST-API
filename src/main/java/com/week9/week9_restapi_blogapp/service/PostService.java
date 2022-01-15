package com.week9.week9_restapi_blogapp.service;

import com.week9.week9_restapi_blogapp.dto.PostRequestDTO;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostModel addPost(UserModel userModel, PostModel postModel);

//    List<PostLikes> getAllPost(UserModel user);
    List<PostModel> getPostsByUser(UserModel userModel);

    void updatePost(PostModel post);
    List<PostModel> viewAllPosts();
    String addPostToFavouriteList(Long userId, Long postId);


    PostModel getPostById(Long id);


}
