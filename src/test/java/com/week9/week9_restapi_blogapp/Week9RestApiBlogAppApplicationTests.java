package com.week9.week9_restapi_blogapp;

import com.week9.week9_restapi_blogapp.dto.ResponseDTO;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.UserRepository;
import com.week9.week9_restapi_blogapp.serviceImplementation.UserServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class Week9RestApiBlogAppApplicationTests {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImplementation userService;
    private UserModel user;

    @BeforeEach
    void setUp() {
        user = new UserModel();
        user.setFullName("Amara Ojiakor");
        user.setEmailAddress("user@gmail.com");
        user.setPassword("1234");
    }


    @Test
    void shouldAddUserTest() {
        //mock userRepository
        when(userRepository.save(any(UserModel.class))).thenReturn(user);
        //call the method to be tested
        userService.addUser(user);
//            userService.logInUser(user);
        //Assertions
        verify(userRepository, times(1)).save(any(UserModel.class));
    }

//    @Test
//    void shouldLogInUserTest() {
//        //mock userRepository
////
//        when(userRepository.existsUserModelByEmailAddress(anyString())).thenReturn(boolean.of(user));
//        //then call the method to be tested
//        ResponseDTO foundUser = userService.logInUser(user);
//        //assertions
//        assertNotNull(foundUser);
//        assertEquals("user@gmail.com", foundUser.getData().getEmailAddress());
//        verify(userRepository, times(1)).getUserByEmailAddressAndPassword(anyString(), anyString());
//    }
//
//
//    void shouldLogInUserTest() {
//        //mock userRepository
////
//        when(userRepository.getUserByEmailAddressAndPassword(anyString(), anyString())).thenReturn(Optional.of(user));
//        //then call the method to be tested
//        ResponseDTO foundUser = userService.logInUser(user);
//        //assertions
//        assertNotNull(foundUser);
//        assertEquals("user@gmail.com", foundUser.getData().getEmailAddress());
//        verify(userRepository, times(1)).getUserByEmailAddressAndPassword(anyString(), anyString());
//    }
}