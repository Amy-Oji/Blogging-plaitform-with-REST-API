package com.week9.week9_restapi_blogapp.serviceImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.week9.week9_restapi_blogapp.model.CommentModel;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import com.week9.week9_restapi_blogapp.repository.CommentRepository;
import com.week9.week9_restapi_blogapp.repository.PostRepository;
import com.week9.week9_restapi_blogapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CommentServiceImplementation.class})
@ExtendWith(SpringExtension.class)
class CommentServiceImplementationTest {
    @MockBean
    private CommentRepository commentRepository;

    @Autowired
    private CommentServiceImplementation commentServiceImplementation;

    @MockBean
    private PostRepository postRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testMakeComment() {
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
        Optional<PostModel> ofResult1 = Optional.of(postModel);

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

        PostModel postModel1 = new PostModel();
        postModel1.setBody("Not all who wander are lost");
        postModel1.setListOfComments(new ArrayList<>());
        postModel1.setPostId(123L);
        postModel1.setPostLikes(new ArrayList<>());
        postModel1.setTitle("Dr");
        postModel1.setUserFavourites(userModel3);
        postModel1.setUserModel(userModel4);
        when(this.postRepository.save((PostModel) any())).thenReturn(postModel1);
        when(this.postRepository.getPostModelByPostId((Long) any())).thenReturn(ofResult1);

        UserModel userModel5 = new UserModel();
        userModel5.setEmailAddress("42 Main St");
        userModel5.setFavouritePosts(new ArrayList<>());
        userModel5.setFullName("Dr Jane Doe");
        userModel5.setListOfFriends(new ArrayList<>());
        userModel5.setPassword("iloveyou");
        userModel5.setUserId(123L);
        userModel5.setUserPosts(new ArrayList<>());

        UserModel userModel6 = new UserModel();
        userModel6.setEmailAddress("42 Main St");
        userModel6.setFavouritePosts(new ArrayList<>());
        userModel6.setFullName("Dr Jane Doe");
        userModel6.setListOfFriends(new ArrayList<>());
        userModel6.setPassword("iloveyou");
        userModel6.setUserId(123L);
        userModel6.setUserPosts(new ArrayList<>());

        PostModel postModel2 = new PostModel();
        postModel2.setBody("Not all who wander are lost");
        postModel2.setListOfComments(new ArrayList<>());
        postModel2.setPostId(123L);
        postModel2.setPostLikes(new ArrayList<>());
        postModel2.setTitle("Dr");
        postModel2.setUserFavourites(userModel5);
        postModel2.setUserModel(userModel6);

        UserModel userModel7 = new UserModel();
        userModel7.setEmailAddress("42 Main St");
        userModel7.setFavouritePosts(new ArrayList<>());
        userModel7.setFullName("Dr Jane Doe");
        userModel7.setListOfFriends(new ArrayList<>());
        userModel7.setPassword("iloveyou");
        userModel7.setUserId(123L);
        userModel7.setUserPosts(new ArrayList<>());

        CommentModel commentModel = new CommentModel();
        commentModel.setComment("Comment");
        commentModel.setCommentId(123L);
        commentModel.setPost(postModel2);
        commentModel.setUser(userModel7);
        when(this.commentRepository.save((CommentModel) any())).thenReturn(commentModel);

        UserModel userModel8 = new UserModel();
        userModel8.setEmailAddress("42 Main St");
        userModel8.setFavouritePosts(new ArrayList<>());
        userModel8.setFullName("Dr Jane Doe");
        userModel8.setListOfFriends(new ArrayList<>());
        userModel8.setPassword("iloveyou");
        userModel8.setUserId(123L);
        userModel8.setUserPosts(new ArrayList<>());

        UserModel userModel9 = new UserModel();
        userModel9.setEmailAddress("42 Main St");
        userModel9.setFavouritePosts(new ArrayList<>());
        userModel9.setFullName("Dr Jane Doe");
        userModel9.setListOfFriends(new ArrayList<>());
        userModel9.setPassword("iloveyou");
        userModel9.setUserId(123L);
        userModel9.setUserPosts(new ArrayList<>());

        PostModel postModel3 = new PostModel();
        postModel3.setBody("Not all who wander are lost");
        postModel3.setListOfComments(new ArrayList<>());
        postModel3.setPostId(123L);
        postModel3.setPostLikes(new ArrayList<>());
        postModel3.setTitle("Dr");
        postModel3.setUserFavourites(userModel8);
        postModel3.setUserModel(userModel9);

        UserModel userModel10 = new UserModel();
        userModel10.setEmailAddress("42 Main St");
        userModel10.setFavouritePosts(new ArrayList<>());
        userModel10.setFullName("Dr Jane Doe");
        userModel10.setListOfFriends(new ArrayList<>());
        userModel10.setPassword("iloveyou");
        userModel10.setUserId(123L);
        userModel10.setUserPosts(new ArrayList<>());

        CommentModel commentModel1 = new CommentModel();
        commentModel1.setComment("Comment");
        commentModel1.setCommentId(123L);
        commentModel1.setPost(postModel3);
        commentModel1.setUser(userModel10);
        assertTrue(this.commentServiceImplementation.makeComment(commentModel1, 123L, 123L));
        verify(this.userRepository).findById((Long) any());
        verify(this.postRepository).getPostModelByPostId((Long) any());
        verify(this.postRepository).save((PostModel) any());
        verify(this.commentRepository).save((CommentModel) any());
        assertEquals(userModel8, commentModel1.getUser());
        PostModel post = commentModel1.getPost();
        assertSame(postModel, post);
        assertEquals(1, post.getListOfComments().size());
    }

    @Test
    void testMakeComment2() {
        when(this.userRepository.findById((Long) any())).thenReturn(Optional.empty());

        UserModel userModel = new UserModel();
        userModel.setEmailAddress("42 Main St");
        userModel.setFavouritePosts(new ArrayList<>());
        userModel.setFullName("Dr Jane Doe");
        userModel.setListOfFriends(new ArrayList<>());
        userModel.setPassword("iloveyou");
        userModel.setUserId(123L);
        userModel.setUserPosts(new ArrayList<>());

        UserModel userModel1 = new UserModel();
        userModel1.setEmailAddress("42 Main St");
        userModel1.setFavouritePosts(new ArrayList<>());
        userModel1.setFullName("Dr Jane Doe");
        userModel1.setListOfFriends(new ArrayList<>());
        userModel1.setPassword("iloveyou");
        userModel1.setUserId(123L);
        userModel1.setUserPosts(new ArrayList<>());

        PostModel postModel = new PostModel();
        postModel.setBody("Not all who wander are lost");
        postModel.setListOfComments(new ArrayList<>());
        postModel.setPostId(123L);
        postModel.setPostLikes(new ArrayList<>());
        postModel.setTitle("Dr");
        postModel.setUserFavourites(userModel);
        postModel.setUserModel(userModel1);
        Optional<PostModel> ofResult = Optional.of(postModel);

        UserModel userModel2 = new UserModel();
        userModel2.setEmailAddress("42 Main St");
        userModel2.setFavouritePosts(new ArrayList<>());
        userModel2.setFullName("Dr Jane Doe");
        userModel2.setListOfFriends(new ArrayList<>());
        userModel2.setPassword("iloveyou");
        userModel2.setUserId(123L);
        userModel2.setUserPosts(new ArrayList<>());

        UserModel userModel3 = new UserModel();
        userModel3.setEmailAddress("42 Main St");
        userModel3.setFavouritePosts(new ArrayList<>());
        userModel3.setFullName("Dr Jane Doe");
        userModel3.setListOfFriends(new ArrayList<>());
        userModel3.setPassword("iloveyou");
        userModel3.setUserId(123L);
        userModel3.setUserPosts(new ArrayList<>());

        PostModel postModel1 = new PostModel();
        postModel1.setBody("Not all who wander are lost");
        postModel1.setListOfComments(new ArrayList<>());
        postModel1.setPostId(123L);
        postModel1.setPostLikes(new ArrayList<>());
        postModel1.setTitle("Dr");
        postModel1.setUserFavourites(userModel2);
        postModel1.setUserModel(userModel3);
        when(this.postRepository.save((PostModel) any())).thenReturn(postModel1);
        when(this.postRepository.getPostModelByPostId((Long) any())).thenReturn(ofResult);

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

        PostModel postModel2 = new PostModel();
        postModel2.setBody("Not all who wander are lost");
        postModel2.setListOfComments(new ArrayList<>());
        postModel2.setPostId(123L);
        postModel2.setPostLikes(new ArrayList<>());
        postModel2.setTitle("Dr");
        postModel2.setUserFavourites(userModel4);
        postModel2.setUserModel(userModel5);

        UserModel userModel6 = new UserModel();
        userModel6.setEmailAddress("42 Main St");
        userModel6.setFavouritePosts(new ArrayList<>());
        userModel6.setFullName("Dr Jane Doe");
        userModel6.setListOfFriends(new ArrayList<>());
        userModel6.setPassword("iloveyou");
        userModel6.setUserId(123L);
        userModel6.setUserPosts(new ArrayList<>());

        CommentModel commentModel = new CommentModel();
        commentModel.setComment("Comment");
        commentModel.setCommentId(123L);
        commentModel.setPost(postModel2);
        commentModel.setUser(userModel6);
        when(this.commentRepository.save((CommentModel) any())).thenReturn(commentModel);

        UserModel userModel7 = new UserModel();
        userModel7.setEmailAddress("42 Main St");
        userModel7.setFavouritePosts(new ArrayList<>());
        userModel7.setFullName("Dr Jane Doe");
        userModel7.setListOfFriends(new ArrayList<>());
        userModel7.setPassword("iloveyou");
        userModel7.setUserId(123L);
        userModel7.setUserPosts(new ArrayList<>());

        UserModel userModel8 = new UserModel();
        userModel8.setEmailAddress("42 Main St");
        userModel8.setFavouritePosts(new ArrayList<>());
        userModel8.setFullName("Dr Jane Doe");
        userModel8.setListOfFriends(new ArrayList<>());
        userModel8.setPassword("iloveyou");
        userModel8.setUserId(123L);
        userModel8.setUserPosts(new ArrayList<>());

        PostModel postModel3 = new PostModel();
        postModel3.setBody("Not all who wander are lost");
        postModel3.setListOfComments(new ArrayList<>());
        postModel3.setPostId(123L);
        postModel3.setPostLikes(new ArrayList<>());
        postModel3.setTitle("Dr");
        postModel3.setUserFavourites(userModel7);
        postModel3.setUserModel(userModel8);

        UserModel userModel9 = new UserModel();
        userModel9.setEmailAddress("42 Main St");
        userModel9.setFavouritePosts(new ArrayList<>());
        userModel9.setFullName("Dr Jane Doe");
        userModel9.setListOfFriends(new ArrayList<>());
        userModel9.setPassword("iloveyou");
        userModel9.setUserId(123L);
        userModel9.setUserPosts(new ArrayList<>());

        CommentModel commentModel1 = new CommentModel();
        commentModel1.setComment("Comment");
        commentModel1.setCommentId(123L);
        commentModel1.setPost(postModel3);
        commentModel1.setUser(userModel9);
        assertFalse(this.commentServiceImplementation.makeComment(commentModel1, 123L, 123L));
        verify(this.userRepository).findById((Long) any());
        verify(this.postRepository).getPostModelByPostId((Long) any());
    }

    @Test
    void testMakeComment3() {
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
        when(this.postRepository.getPostModelByPostId((Long) any())).thenReturn(Optional.empty());

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

        PostModel postModel1 = new PostModel();
        postModel1.setBody("Not all who wander are lost");
        postModel1.setListOfComments(new ArrayList<>());
        postModel1.setPostId(123L);
        postModel1.setPostLikes(new ArrayList<>());
        postModel1.setTitle("Dr");
        postModel1.setUserFavourites(userModel3);
        postModel1.setUserModel(userModel4);

        UserModel userModel5 = new UserModel();
        userModel5.setEmailAddress("42 Main St");
        userModel5.setFavouritePosts(new ArrayList<>());
        userModel5.setFullName("Dr Jane Doe");
        userModel5.setListOfFriends(new ArrayList<>());
        userModel5.setPassword("iloveyou");
        userModel5.setUserId(123L);
        userModel5.setUserPosts(new ArrayList<>());

        CommentModel commentModel = new CommentModel();
        commentModel.setComment("Comment");
        commentModel.setCommentId(123L);
        commentModel.setPost(postModel1);
        commentModel.setUser(userModel5);
        when(this.commentRepository.save((CommentModel) any())).thenReturn(commentModel);

        UserModel userModel6 = new UserModel();
        userModel6.setEmailAddress("42 Main St");
        userModel6.setFavouritePosts(new ArrayList<>());
        userModel6.setFullName("Dr Jane Doe");
        userModel6.setListOfFriends(new ArrayList<>());
        userModel6.setPassword("iloveyou");
        userModel6.setUserId(123L);
        userModel6.setUserPosts(new ArrayList<>());

        UserModel userModel7 = new UserModel();
        userModel7.setEmailAddress("42 Main St");
        userModel7.setFavouritePosts(new ArrayList<>());
        userModel7.setFullName("Dr Jane Doe");
        userModel7.setListOfFriends(new ArrayList<>());
        userModel7.setPassword("iloveyou");
        userModel7.setUserId(123L);
        userModel7.setUserPosts(new ArrayList<>());

        PostModel postModel2 = new PostModel();
        postModel2.setBody("Not all who wander are lost");
        postModel2.setListOfComments(new ArrayList<>());
        postModel2.setPostId(123L);
        postModel2.setPostLikes(new ArrayList<>());
        postModel2.setTitle("Dr");
        postModel2.setUserFavourites(userModel6);
        postModel2.setUserModel(userModel7);

        UserModel userModel8 = new UserModel();
        userModel8.setEmailAddress("42 Main St");
        userModel8.setFavouritePosts(new ArrayList<>());
        userModel8.setFullName("Dr Jane Doe");
        userModel8.setListOfFriends(new ArrayList<>());
        userModel8.setPassword("iloveyou");
        userModel8.setUserId(123L);
        userModel8.setUserPosts(new ArrayList<>());

        CommentModel commentModel1 = new CommentModel();
        commentModel1.setComment("Comment");
        commentModel1.setCommentId(123L);
        commentModel1.setPost(postModel2);
        commentModel1.setUser(userModel8);
        assertFalse(this.commentServiceImplementation.makeComment(commentModel1, 123L, 123L));
        verify(this.userRepository).findById((Long) any());
        verify(this.postRepository).getPostModelByPostId((Long) any());
    }
}

