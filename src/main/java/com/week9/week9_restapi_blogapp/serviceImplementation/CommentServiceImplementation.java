package com.week9.week9_restapi_blogapp.serviceImplementation;

import com.week9.week9_restapi_blogapp.model.CommentModel;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.CommentRepository;
import com.week9.week9_restapi_blogapp.repository.PostRepository;
import com.week9.week9_restapi_blogapp.repository.UserRepository;
import com.week9.week9_restapi_blogapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentServiceImplementation(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommentModel makeComment(Long userId, Long postId, CommentModel comment) {

        UserModel user = userRepository.findById(userId).orElseThrow(NullPointerException::new);
        PostModel post = postRepository.findByPostId(postId).orElseThrow(NullPointerException::new);


        if(user != null && post !=null){
            comment.setUserId(user);
            comment.setPostId(post);

            commentRepository.save(comment);
            return comment;
        }
        return null;
    }
}
