package com.week9.week9_restapi_blogapp.service;

import com.week9.week9_restapi_blogapp.dto.PostRequestDTO;
import com.week9.week9_restapi_blogapp.model.PostLikes;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;

import java.util.List;

public interface PostService {
    PostModel addPost(Long id, PostModel postModel);

    List<PostLikes> getAllPost(UserModel user);

    void updatePost(PostModel post);

    void deletePost(PostModel post);

    PostModel getPostById(Long id);

}
