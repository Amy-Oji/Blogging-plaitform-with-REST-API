package com.week9.week9_restapi_blogapp.serviceImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.PostRepository;
import com.week9.week9_restapi_blogapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PostServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class PostServiceImplementationTest {
    @MockBean
    private PostRepository postRepository;

    @Autowired
    private PostServiceImplementation postServiceImplementation;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserServiceImplementation userServiceImplementation;

    @Test
    void testAddPost() {
        UserModel userModel = new UserModel();
        userModel.setEmailAddress("42 Main St");
        userModel.setFavouritePosts(new ArrayList<>());
        userModel.setFullName("Dr Jane Doe");
        userModel.setListOfFriends(new ArrayList<>());
        userModel.setPassword("iloveyou");
        userModel.setUserId(123L);
        userModel.setUserPosts(new ArrayList<>());
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);

        UserModel userModel1 = new UserModel();
        userModel1.setEmailAddress("42 Main St");
        userModel1.setFavouritePosts(new ArrayList<>());
        userModel1.setFullName("Dr Jane Doe");
        userModel1.setListOfFriends(new ArrayList<>());
        userModel1.setPassword("iloveyou");
        userModel1.setUserId(123L);
        userModel1.setUserPosts(new ArrayList<>());

        UserModel userModel2 = new UserModel();
        userModel2.setEmailAddress("42 Main St");
        userModel2.setFavouritePosts(new ArrayList<>());
        userModel2.setFullName("Dr Jane Doe");
        userModel2.setListOfFriends(new ArrayList<>());
        userModel2.setPassword("iloveyou");
        userModel2.setUserId(123L);
        userModel2.setUserPosts(new ArrayList<>());

        PostModel postModel = new PostModel();
        postModel.setBody("Not all who wander are lost");
        postModel.setListOfComments(new ArrayList<>());
        postModel.setPostId(123L);
        postModel.setPostLikes(new ArrayList<>());
        postModel.setTitle("Dr");
        postModel.setUserFavourites(userModel1);
        postModel.setUserModel(userModel2);
        when(this.postRepository.save((PostModel) any())).thenReturn(postModel);

        UserModel userModel3 = new UserModel();
        userModel3.setEmailAddress("42 Main St");
        userModel3.setFavouritePosts(new ArrayList<>());
        userModel3.setFullName("Dr Jane Doe");
        userModel3.setListOfFriends(new ArrayList<>());
        userModel3.setPassword("iloveyou");
        userModel3.setUserId(123L);
        userModel3.setUserPosts(new ArrayList<>());

        UserModel userModel4 = new UserModel();
        userModel4.setEmailAddress("42 Main St");
        userModel4.setFavouritePosts(new ArrayList<>());
        userModel4.setFullName("Dr Jane Doe");
        userModel4.setListOfFriends(new ArrayList<>());
        userModel4.setPassword("iloveyou");
        userModel4.setUserId(123L);
        userModel4.setUserPosts(new ArrayList<>());

        UserModel userModel5 = new UserModel();
        userModel5.setEmailAddress("42 Main St");
        userModel5.setFavouritePosts(new ArrayList<>());
        userModel5.setFullName("Dr Jane Doe");
        userModel5.setListOfFriends(new ArrayList<>());
        userModel5.setPassword("iloveyou");
        userModel5.setUserId(123L);
        userModel5.setUserPosts(new ArrayList<>());

        PostModel postModel1 = new PostModel();
        postModel1.setBody("Not all who wander are lost");
        postModel1.setListOfComments(new ArrayList<>());
        postModel1.setPostId(123L);
        postModel1.setPostLikes(new ArrayList<>());
        postModel1.setTitle("Dr");
        postModel1.setUserFavourites(userModel4);
        postModel1.setUserModel(userModel5);
        PostModel actualAddPostResult = this.postServiceImplementation.addPost(userModel3, postModel1);
        assertSame(postModel1, actualAddPostResult);
        assertEquals(userModel4, actualAddPostResult.getUserModel());
        verify(this.userRepository).findById((Long) any());
        verify(this.postRepository).save((PostModel) any());
        assertEquals(1, userModel3.getUserPosts().size());
    }

    @Test
    void testViewAllPosts() {
        ArrayList<PostModel> postModelList = new ArrayList<>();
        when(this.postRepository.findAll()).thenReturn(postModelList);
        List<PostModel> actualViewAllPostsResult = this.postServiceImplementation.viewAllPosts();
        assertSame(postModelList, actualViewAllPostsResult);
        assertTrue(actualViewAllPostsResult.isEmpty());
        verify(this.postRepository).findAll();
    }

    @Test
    void testViewAllPosts2() {
        ArrayList<PostModel> postModelList = new ArrayList<>();
        when(this.postRepository.findAll()).thenReturn(postModelList);
        List<PostModel> actualViewAllPostsResult = this.postServiceImplementation.viewAllPosts();
        assertSame(postModelList, actualViewAllPostsResult);
        assertTrue(actualViewAllPostsResult.isEmpty());
        verify(this.postRepository).findAll();
    }

    @Test
    void testViewAllPosts3() {
        ArrayList<PostModel> postModelList = new ArrayList<>();
        when(this.postRepository.findAll()).thenReturn(postModelList);
        List<PostModel> actualViewAllPostsResult = this.postServiceImplementation.viewAllPosts();
        assertSame(postModelList, actualViewAllPostsResult);
        assertTrue(actualViewAllPostsResult.isEmpty());
        verify(this.postRepository).findAll();
    }

    @Test
    void testViewAllPosts4() {
        ArrayList<PostModel> postModelList = new ArrayList<>();
        when(this.postRepository.findAll()).thenReturn(postModelList);
        List<PostModel> actualViewAllPostsResult = this.postServiceImplementation.viewAllPosts();
        assertSame(postModelList, actualViewAllPostsResult);
        assertTrue(actualViewAllPostsResult.isEmpty());
        verify(this.postRepository).findAll();
    }

    @Test
    void testFindPostByFriends() {
        when(this.userServiceImplementation.getFriends((Long) any())).thenReturn(new ArrayList<>());

        UserModel userModel = new UserModel();
        userModel.setEmailAddress("42 Main St");
        userModel.setFavouritePosts(new ArrayList<>());
        userModel.setFullName("Dr Jane Doe");
        userModel.setListOfFriends(new ArrayList<>());
        userModel.setPassword("iloveyou");
        userModel.setUserId(123L);
        userModel.setUserPosts(new ArrayList<>());
        when(this.userRepository.getById((Long) any())).thenReturn(userModel);
        assertNull(this.postServiceImplementation.findPostByFriends(123L));
        verify(this.userServiceImplementation).getFriends((Long) any());
        verify(this.userRepository).getById((Long) any());
    }
}

