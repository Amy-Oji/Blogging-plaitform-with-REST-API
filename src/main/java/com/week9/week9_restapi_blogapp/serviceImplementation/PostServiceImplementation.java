package com.week9.week9_restapi_blogapp.serviceImplementation;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.PostLikes;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.PostRepository;
import com.week9.week9_restapi_blogapp.repository.UserRepository;
import com.week9.week9_restapi_blogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImplementation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addPost(UserModel user, PostModel post) {
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public List<PostLikes> getAllPost(UserModel user) {
        return null;
    }

    @Override
    public void updatePost(PostModel post) {

    }

    @Override
    public void deletePost(PostModel post) {

    }

    @Override
    public PostModel getPostById(Long id) {
        return null;
    }
}
