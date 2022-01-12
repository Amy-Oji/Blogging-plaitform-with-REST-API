package com.week9.week9_restapi_blogapp.service;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.UserModel;

import java.util.Optional;

public interface UserService {
    ResponseDTO addUser(UserModel userModel);
    ResponseDTO loginUser(UserModel userModel);
    Optional<UserModel> getAllUser(UserModel userModel);
}
