package com.week9.week9_restapi_blogapp.repository;

import com.week9.week9_restapi_blogapp.dto.PostRequestDTO;
import com.week9.week9_restapi_blogapp.model.PostModel;
import com.week9.week9_restapi_blogapp.model.UserModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {

//    Optional<PostModel> findByPostId(Long id); // postModel was here and not optional
//    List<PostModel> findAll(PostModel postModel);
//    List<PostModel> getAllByUserId(Long id);
    List<PostModel> findAllByUserModel(UserModel userModel);
    Optional<PostModel> getPostModelByPostId(Long postId); // postmodel was return type.




//    List<PostModel> findAllByUserModel(UserModel userModel);
//    PostModel save(PostRequestDTO postRequestDTO);
}
