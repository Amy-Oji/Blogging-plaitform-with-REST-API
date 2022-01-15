package com.week9.week9_restapi_blogapp.controller;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.dto.Response;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.service.UserService;
import com.week9.week9_restapi_blogapp.serviceImplementation.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userServiceImplementation;


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

    @GetMapping("/listOfFriends/{user_id}")
    public List<UserModel> getListOfFriends(@PathVariable Long user_id){

            return userServiceImplementation.getFriends(user_id);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public  String deleteUser(@PathVariable Long userId){
        userServiceImplementation.deleteAccount(userId);
        return "User Deleted.";
    }

}


