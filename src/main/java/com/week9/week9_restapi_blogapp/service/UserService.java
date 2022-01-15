package com.week9.week9_restapi_blogapp.service;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.UserModel;

import java.util.List;

public interface UserService {
    ResponseDTO addUser(UserModel userModel);
    UserModel loginUser(UserModel userModel);
//    UserModel getAllUser(UserModel userModel);
    UserModel getUserById(Long userId);
    String addFriend(Long userId, Long friendId);
    String deleteAccount(Long userId);
    List<UserModel> getFriends(Long userId);


}
