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

    List<PostModel> findAllByUserModel(UserModel userModel);

    Optional<PostModel> getPostModelByPostId(Long postId);

    void findPostModelByUserModel(UserModel userModel);


}