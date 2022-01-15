package com.week9.week9_restapi_blogapp.service;

import com.week9.week9_restapi_blogapp.model.CommentModel;
import com.week9.week9_restapi_blogapp.model.PostModel;

import java.util.List;

public interface CommentService {
    boolean makeComment(CommentModel commentModel, Long userId, Long postId);
    CommentModel getCommentById(Long id);
    List<CommentModel> findCommentByPost(PostModel post);



}
