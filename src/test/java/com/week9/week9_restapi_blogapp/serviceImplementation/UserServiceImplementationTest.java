package com.week9.week9_restapi_blogapp.serviceImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.UserRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplementationTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @Test
    void testAddUser() {
        when(this.userRepository.existsUserModelByEmailAddress((String) any())).thenReturn(true);

        UserModel userModel = new UserModel();
        userModel.setEmailAddress("42 Main St");
        userModel.setFavouritePosts(new ArrayList<>());
        userModel.setFullName("Dr Jane Doe");
        userModel.setListOfFriends(new ArrayList<>());
        userModel.setPassword("iloveyou");
        userModel.setUserId(123L);
        userModel.setUserPosts(new ArrayList<>());
        ResponseDTO actualAddUserResult = this.userServiceImplementation.addUser(userModel);
        assertEquals("User already exits. login instead", actualAddUserResult.getMessage());
        assertFalse(actualAddUserResult.isStatus());
        verify(this.userRepository).existsUserModelByEmailAddress((String) any());
    }

    @Test
    void testAddUser2() {
        UserModel userModel = new UserModel();
        userModel.setEmailAddress("42 Main St");
        userModel.setFavouritePosts(new ArrayList<>());
        userModel.setFullName("Dr Jane Doe");
        userModel.setListOfFriends(new ArrayList<>());
        userModel.setPassword("iloveyou");
        userModel.setUserId(123L);
        userModel.setUserPosts(new ArrayList<>());
        when(this.userRepository.save((UserModel) any())).thenReturn(userModel);
        when(this.userRepository.existsUserModelByEmailAddress((String) any())).thenReturn(false);

        UserModel userModel1 = new UserModel();
        userModel1.setEmailAddress("42 Main St");
        userModel1.setFavouritePosts(new ArrayList<>());
        userModel1.setFullName("Dr Jane Doe");
        userModel1.setListOfFriends(new ArrayList<>());
        userModel1.setPassword("iloveyou");
        userModel1.setUserId(123L);
        userModel1.setUserPosts(new ArrayList<>());
        ResponseDTO actualAddUserResult = this.userServiceImplementation.addUser(userModel1);
        assertEquals("login successful", actualAddUserResult.getMessage());
        assertTrue(actualAddUserResult.isStatus());
        assertEquals(userModel1, actualAddUserResult.getUser());
        verify(this.userRepository).existsUserModelByEmailAddress((String) any());
        verify(this.userRepository).save((UserModel) any());
    }
}

