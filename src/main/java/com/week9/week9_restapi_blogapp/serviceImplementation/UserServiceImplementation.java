package com.week9.week9_restapi_blogapp.serviceImplementation;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.UserRepository;
import com.week9.week9_restapi_blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseDTO addUser(UserModel userModel) {
        ResponseDTO response = new ResponseDTO();
        if (userRepository.existsUserModelByEmailAddress(userModel.getEmailAddress())){
            response.setMessage("User already exits. login instead");
            response.setStatus(false);
            return response;
        }
        UserModel loggedUser = userRepository.save(userModel);
        response.setUser(loggedUser);
        response.setStatus(true);
        response.setMessage("login successful");
        return response;
    }

    @Override
    public UserModel loginUser(UserModel userModel) {
        UserModel user = userRepository.getById(userModel.getUserId());
        if(user != null){
            return userRepository.getUserModelByEmailAddress(userModel.getEmailAddress()).get();
        }
        return null;
    }



    @Override
    public UserModel getUserById(Long userId) {
        UserModel userModel = userRepository.getUserModelByUserId(userId);
        return userModel;
    }


    @Override
    public String addFriend(Long userId, Long friendId) {
        if(userId.equals(friendId)){
            return "You cannot add yourself";
        }
        if(userRepository.findById(friendId).isEmpty()){
            return "user not found";
        }
        UserModel user = userRepository.getById(userId);
        UserModel friend = userRepository.getById(friendId);
        user.getListOfFriends().add(friend);
        friend.getListOfFriends().add(user);
        userRepository.save(user);
        userRepository.save(friend);
        return user.getFullName() + " " + "is now friends with " + friend.getFullName();

    }
    @Override
    public String deleteAccount(Long userId){
        UserModel userModel = userRepository.getById(userId);
        userRepository.delete(userModel);
        return "User deleted";
    }
    @Override
    public List<UserModel> getFriends(Long userId){
        UserModel userModel = userRepository.getById(userId);
        return userModel.getListOfFriends();
    }




}