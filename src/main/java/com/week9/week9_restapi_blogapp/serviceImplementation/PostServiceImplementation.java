package com.week9.week9_restapi_blogapp.serviceImplementation;

import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.PostRepository;
import com.week9.week9_restapi_blogapp.repository.UserRepository;
import com.week9.week9_restapi_blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public PostModel addPost(UserModel userModel, PostModel postModel) {
        UserModel userModel1 = userRepository.findById(userModel.getUserId()).orElseThrow(NullPointerException::new);

        if (userModel != null) {
            postModel.setUserModel(userModel1);
            postRepository.save(postModel);
            userModel.getUserPosts().add(postModel); //added
            return postModel;
            }
//        PostModel postModel1 = new PostModel();
//        postModel1.setTitle(postModel.getTitle());
//        postModel1.setBody(postModel.getBody());
        return null;
        }

//        @Override
//        public List<PostLikes> getAllPost (UserModel user){
//            return null;
//
//        }

        @Override
        public List<PostModel> getPostsByUser (UserModel userModel){
            return postRepository.findAllByUserModel(userModel);
        }

        @Override
        public void updatePost (PostModel post){

        }

        @Override
        public List<PostModel> viewAllPosts () {
            return postRepository.findAll();
        }


        @Override
        public PostModel getPostById (Long id){
            return postRepository.getPostModelByPostId(id).get();
        }

    // add post to favourite
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

    //controller
//    @PostMapping("/addPostToFavourite/{post_id}")
//    public String addPostToFavourite(@PathVariable Long post_id, HttpSession session){
//        Long user_id = (Long) session.getAttribute("id");
//        postServiceImp.addPostToFavouriteList(user_id,post_id);
//        return "post added to favourite";
//    }
    //Add friends serviceImpl
//    @Override
//    public String addFriend(Long user_id, Long friend_id) {
//        if(user_id.equals(friend_id)){
//            return "You cannot add yourself";
//        }
//        if(userRepository.findById(friend_id).isEmpty()){
//            return "user not found";
//        }
//        Person person = userRepository.getById(user_id);
//        Person friend= userRepository.getById(friend_id);
//        person.getFriends().add(friend);
//        friend.getFriends().add(person);
//        userRepository.save(person);
//        userRepository.save(friend);
//        return person.getUsername() + " " + "is now friends with " + friend.getUsername();
//    }
//    // controller add friend
//    @PostMapping("/addPerson/{friend_id}")
//    public String addFriend(HttpSession session, @PathVariable Long friend_id ){
//        Long id = (Long) session.getAttribute("id");
//        userServiceImp.addFriend(id,friend_id);
//        return "Friends added";
//    }

}
