package com.week9.week9_restapi_blogapp.service;

import com.week9.week9_restapi_blogapp.model.CommentModel;
import com.week9.week9_restapi_blogapp.model.PostModel;

public interface CommentService {
    CommentModel makeComment(Long userId, Long postId, CommentModel commentModel);

}
