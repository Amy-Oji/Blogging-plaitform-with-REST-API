package com.week9.week9_restapi_blogapp.controller;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.service.UserService;
import com.week9.week9_restapi_blogapp.serviceImplementation.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/login")
    public ResponseEntity<UserModel> loginUser(@RequestBody UserModel user) {
        ResponseDTO response = userServiceImplementation.loginUser(user);
        try {
            if (response.isStatus()) {
                return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


}
