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

//    @Override
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
    @Override
    public UserModel loginUser(UserModel userModel) {
//        ResponseDTO response = new ResponseDTO();
//        System.out.println("I am Here" + userModel);
        UserModel user = userRepository.getById(userModel.getUserId());
        if(user != null){
            return userRepository.getUserModelByEmailAddress(userModel.getEmailAddress()).get();
        }
        return null;

////        if (userRepository.getUserByEmailAddress(userModel.getEmailAddress()).isPresent()){
//            var loginUser = userRepository.getUserModelByEmailAddress(userModel.getEmailAddress());
//        System.out.println("Another : " +loginUser.get());
//            if (loginUser.isPresent()) {
//                response.setStatus(true);
//                response.setUser(loginUser.get());
//                response.setMessage("Login Successful!");
//                System.out.println("Here " + loginUser);
//                return response;
//            }
////        }
//        response.setStatus(false);
//        response.setMessage("Not a user");
//        return response;

    }

//    @Override
//    public Optional<UserModel> getAllUser(UserModel userModel) {
//        return Optional.empty();
//    }

    @Override
    public UserModel getUserById(Long userId) {
        UserModel userModel = userRepository.getUserModelByUserId(userId);
        return userModel;
    }



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


}