package com.week9.week9_restapi_blogapp.controller;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.dto.Response;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.serviceImplementation.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImplementation userServiceImplementation;

    @PostMapping("/register")
    public ResponseEntity<UserModel> registerUser(@RequestBody UserModel user) {
        ResponseDTO response = userServiceImplementation.addUser(user);
        if (response.isStatus()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/login/{id}")
    public ResponseEntity<?> loginUser(@PathVariable("id") Long id, UserModel userModel) {
        userModel = userServiceImplementation.getUserById(id);
        if (userModel != null)
            userServiceImplementation.loginUser(userModel);
        Response response1 = new Response();
        response1.setResponse("Login successful: " + userModel.getFullName());
        return new ResponseEntity<>(response1, HttpStatus.ACCEPTED);
    }

    @PostMapping("/addPerson/{user_id}/{friend_id}")
    public String addFriend(@PathVariable Long user_id, @PathVariable Long friend_id ){
        if(user_id == friend_id){
            return "you cannot add yourself!";
        }
        userServiceImplementation.addFriend(user_id,friend_id);
        return "Friend added";
    }
}


//    @Override
//    public  String addPostToFavouriteList(Long user_id,Long post_id){
//        Post post = repository.getById(post_id);
//        Person person = userRepository.getById(user_id);
//        if(person.getFavourite().contains(post)){
//            return "Post is already in favourite";
//        }
//        person.getFavourite().add(post);
//        userRepository.save(person);
//        return  "Post added to favourite";
//    }
//    //controller
//    @PostMapping("/addPostToFavourite/{post_id}")
//    public String addPostToFavourite(@PathVariable Long post_id, HttpSession session){
//        Long user_id = (Long) session.getAttribute("id");
//        postServiceImp.addPostToFavouriteList(user_id,post_id);
//        return "post added to favourite";
//    }
//    //Add friends serviceImpl
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
