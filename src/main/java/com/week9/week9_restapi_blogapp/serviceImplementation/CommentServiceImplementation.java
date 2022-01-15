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

import java.util.List;

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
    public boolean makeComment(CommentModel commentModel, Long userId, Long postId) {
        var post = postRepository.getPostModelByPostId(postId);
        var user = userRepository.findById(userId);
        CommentModel comment = new CommentModel();
        comment.setComment(commentModel.getComment());
        if(post.isPresent() && user.isPresent()){
            commentModel.setPost(post.get());
            commentModel.setUser(user.get());
            post.get().getListOfComments().add(commentModel);
            postRepository.save(post.get());
            commentRepository.save(commentModel);
            return true;
        }
        return false;

    }


    @Override
    public List<CommentModel> findCommentByPost(PostModel post) {
        return commentRepository.findCommentByPost(post);
    }

    @Override
    public CommentModel getCommentById(Long id) {
        return commentRepository.findByCommentId(id);
    }
}

