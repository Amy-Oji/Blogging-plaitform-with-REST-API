package com.week9.week9_restapi_blogapp.repository;

import com.week9.week9_restapi_blogapp.model.CommentModel;
import com.week9.week9_restapi_blogapp.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
   CommentModel findCommentModelByCommentId(Long id);

}
