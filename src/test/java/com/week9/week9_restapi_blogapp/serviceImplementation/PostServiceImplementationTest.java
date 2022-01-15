//package com.week9.week9_restapi_blogapp.serviceImplementation;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//import com.week9.week9_restapi_blogapp.model.PostModel;
//import com.week9.week9_restapi_blogapp.model.UserModel;
//import com.week9.week9_restapi_blogapp.repository.PostRepository;
//import com.week9.week9_restapi_blogapp.repository.UserRepository;
//
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {PostServiceImplementation.class})
//@ExtendWith(SpringExtension.class)
//class PostServiceImplementationTest {
//    @MockBean
//    private PostRepository postRepository;
//
//    @Autowired
//    private PostServiceImplementation postServiceImplementation;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @Test
//    void testConstructor() {
//        // TODO: This test is incomplete.
//        //   Reason: R002 Missing observers.
//        //   Diffblue Cover was unable to create an assertion.
//        //   Add getters for the following fields or make them package-private:
//        //     PostServiceImplementation.postRepository
//        //     PostServiceImplementation.userRepository
//
//        PostServiceImplementation actualPostServiceImplementation = new PostServiceImplementation(
//                mock(PostRepository.class), mock(UserRepository.class));
//        UserModel userModel = new UserModel();
//        userModel.setEmailAddress("42 Main St");
//        userModel.setFullName("Dr Jane Doe");
//        userModel.setPassword("iloveyou");
//        userModel.setUserId(123L);
//        userModel.setUserPosts(new ArrayList<>());
//        PostModel postModel = new PostModel();
//        postModel.setBody("Not all who wander are lost");
//        postModel.setListOfComments(new ArrayList<>());
//        postModel.setPostId(123L);
//        postModel.setPostLikes(new ArrayList<>());
//        postModel.setTitle("Dr");
//        postModel.setUserModel(userModel);
//        actualPostServiceImplementation.deletePost(postModel);
//        UserModel userModel1 = new UserModel();
//        userModel1.setEmailAddress("42 Main St");
//        userModel1.setFullName("Dr Jane Doe");
//        userModel1.setPassword("iloveyou");
//        userModel1.setUserId(123L);
//        userModel1.setUserPosts(new ArrayList<>());
//        PostModel postModel1 = new PostModel();
//        postModel1.setBody("Not all who wander are lost");
//        postModel1.setListOfComments(new ArrayList<>());
//        postModel1.setPostId(123L);
//        postModel1.setPostLikes(new ArrayList<>());
//        postModel1.setTitle("Dr");
//        postModel1.setUserModel(userModel1);
//        actualPostServiceImplementation.updatePost(postModel1);
//    }
//
////    @Test
////    void testAddPost() {
////        UserModel userModel = new UserModel();
////        userModel.setEmailAddress("42 Main St");
////        userModel.setFullName("Dr Jane Doe");
////        userModel.setPassword("iloveyou");
////        userModel.setUserId(123L);
////        userModel.setUserPosts(new ArrayList<>());
////        Optional<UserModel> ofResult = Optional.of(userModel);
////        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
////
////        UserModel userModel1 = new UserModel();
////        userModel1.setEmailAddress("42 Main St");
////        userModel1.setFullName("Dr Jane Doe");
////        userModel1.setPassword("iloveyou");
////        userModel1.setUserId(123L);
////        userModel1.setUserPosts(new ArrayList<>());
////
////        PostModel postModel = new PostModel();
////        postModel.setBody("Not all who wander are lost");
////        postModel.setListOfComments(new ArrayList<>());
////        postModel.setPostId(123L);
////        postModel.setPostLikes(new ArrayList<>());
////        postModel.setTitle("Dr");
////        postModel.setUserId(userModel1);
////        when(this.postRepository.save((PostModel) any())).thenReturn(postModel);
////
////        UserModel userModel2 = new UserModel();
////        userModel2.setEmailAddress("42 Main St");
////        userModel2.setFullName("Dr Jane Doe");
////        userModel2.setPassword("iloveyou");
////        userModel2.setUserId(123L);
////        userModel2.setUserPosts(new ArrayList<>());
////
////        PostModel postModel1 = new PostModel();
////        postModel1.setBody("Not all who wander are lost");
////        postModel1.setListOfComments(new ArrayList<>());
////        postModel1.setPostId(123L);
////        postModel1.setPostLikes(new ArrayList<>());
////        postModel1.setTitle("Dr");
////        postModel1.setUserId(userModel2);
////        PostModel actualAddPostResult = this.postServiceImplementation.addPost(123L, postModel1);
////        assertSame(postModel1, actualAddPostResult);
////        assertEquals(userModel2, actualAddPostResult.getUserId());
////        verify(this.userRepository).findById((Long) any());
////        verify(this.postRepository).save((PostModel) any());
////    }
//
//    @Test
//    void testGetAllPost() {
//        UserModel userModel = new UserModel();
//        userModel.setEmailAddress("42 Main St");
//        userModel.setFullName("Dr Jane Doe");
//        userModel.setPassword("iloveyou");
//        userModel.setUserId(123L);
//        userModel.setUserPosts(new ArrayList<>());
//        assertNull(this.postServiceImplementation.getAllPost(userModel));
//    }
//
//    @Test
//    void testGetPostById() {
//        assertNull(this.postServiceImplementation.getPostById(123L));
//    }
//}
//
