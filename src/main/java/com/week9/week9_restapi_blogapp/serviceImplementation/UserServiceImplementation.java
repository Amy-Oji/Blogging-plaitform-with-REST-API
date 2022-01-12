package com.week9.week9_restapi_blogapp.serviceImplementation;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.UserRepository;
import com.week9.week9_restapi_blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//    public ResponseDTO loginUser(UserModel userModel) {
//        Optional<UserModel> userDb = userRepository.getUserByEmailAddressAndPassword
//                (userModel.getEmailAddress(), userModel.getPassword());
//
//        ResponseDTO response = new ResponseDTO();
//
//        if (userDb.isPresent()) {
//            response.setStatus(true);
//            response.setUser(userDb.get());
//            response.setMessage("LogIn successful");
//            return response;
//        }
//        response.setMessage("Invalid email or password");
//        return response;
    public ResponseDTO loginUser(UserModel userModel) {
        ResponseDTO response = new ResponseDTO();

        if (userRepository.existsUserModelByEmailAddress(userModel.getEmailAddress())){
            response.setStatus(true);
            return response;
        }
        response.setStatus(false);
        return response;

    }

    @Override
    public Optional<UserModel> getAllUser(UserModel userModel) {
        return Optional.empty();
    }
}