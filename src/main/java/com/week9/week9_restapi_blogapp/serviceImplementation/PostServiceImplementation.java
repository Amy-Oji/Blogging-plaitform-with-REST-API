package com.week9.week9_restapi_blogapp.serviceImplementation;

import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.PostRepository;
import com.week9.week9_restapi_blogapp.repository.UserRepository;
import com.week9.week9_restapi_blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserServiceImplementation userService;

    @Autowired
    public PostServiceImplementation(PostRepository postRepository, UserRepository userRepository, UserServiceImplementation userService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public PostModel addPost(UserModel userModel, PostModel postModel) {
        UserModel userModel1 = userRepository.findById(userModel.getUserId()).orElseThrow(NullPointerException::new);

        if (userModel != null) {
            postModel.setUserModel(userModel1);
            postRepository.save(postModel);
            userModel.getUserPosts().add(postModel); //added
            return postModel;
            }
        return null;
        }


        @Override
        public List<PostModel> getPostsByUser (UserModel userModel){
            return postRepository.findAllByUserModel(userModel);
        }

        @Override
        public List<PostModel> viewAllPosts () {
            return postRepository.findAll();
        }


        @Override
        public PostModel getPostById (Long id){
            return postRepository.getPostModelByPostId(id).get();
        }



    @Override
    public  String addPostToFavouriteList(Long userId,Long postId){
        PostModel post = postRepository.getById(postId);
        UserModel user = userRepository.getById(userId);
        if(user.getFavouritePosts().contains(post)){
            return "Post is already in favourite";
        }
        user.getFavouritePosts().add(post);
        userRepository.save(user);
        return  "Post added to favourite";
    }
    @Override
  public List<PostModel> findPostByFriends(Long userId){
        UserModel userModel = userRepository.getById(userId);
        List<UserModel> listOfFriends = userService.getFriends(userId);

        List<PostModel>  postMadeByFriends = new ArrayList<>();

        for(int i = 0; i > listOfFriends.size(); i++){

//            postMadeByFriends.add(i);
        }

        return null;
  }
@Override
  public Integer getLike(Long postId){
      PostModel post = postRepository.getById(postId);
      return post.getPostLikes().size();
  }
@Override
  public List<UserModel>  addLikes (Long userId, Long postId){
        UserModel user = userRepository.getById(userId);
        PostModel post = postRepository.getById(postId);
        post.getPostLikes().add(user);
        postRepository.save(post);
        return post.getPostLikes();
  }

    @Override
    public List<PostModel> getListOfFavPosts(Long userId) {
        UserModel user = userRepository.getById(userId);
        return user.getFavouritePosts();
    }

}
