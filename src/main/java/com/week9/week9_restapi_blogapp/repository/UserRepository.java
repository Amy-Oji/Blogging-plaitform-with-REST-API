package com.week9.week9_restapi_blogapp.repository;

import com.sun.istack.NotNull;
import com.week9.week9_restapi_blogapp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Long>{
    Optional<UserModel> getUserModelByEmailAddress(String emailAddress);
    boolean existsUserModelByEmailAddress(@NotNull String emailAddress);
    UserModel getUserModelByUserId(Long userId);

//    default Optional<UserModel> getUserByEmailAddressAndPassword(String emailAddress, String password) {
//        return null;
//    }
}
