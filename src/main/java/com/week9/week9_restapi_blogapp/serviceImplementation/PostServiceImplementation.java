package com.week9.week9_restapi_blogapp.serviceImplementation;

import com.week9.week9_restapi_blogapp.model.PostLikes;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.PostRepository;
import com.week9.week9_restapi_blogapp.repository.UserRepository;
import com.week9.week9_restapi_blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImplementation(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostModel addPost(Long id, PostModel postModel) {
        UserModel userModel = userRepository.findById(id).orElseThrow(NullPointerException::new);

        if(userModel != null){
            postModel.setUserId(userModel);
            postRepository.save(postModel);
            return postModel;
        }
//        PostModel postModel1 = new PostModel();
//        postModel1.setTitle(postModel.getTitle());
//        postModel1.setBody(postModel.getBody());
        return null;
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
