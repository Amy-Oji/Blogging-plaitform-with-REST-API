package com.week9.week9_restapi_blogapp.repository;

import com.week9.week9_restapi_blogapp.model.CommentModel;
import com.week9.week9_restapi_blogapp.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
   CommentModel findCommentModelByCommentId(Long id);

   List<CommentModel> findCommentModelByPost(PostModel post);
   CommentModel findByCommentId(Long id);
   List<CommentModel> findCommentByPost(PostModel post);

   void deleteCommentByCommentId(Long commentId);

   void deleteAllByPost(PostModel post);

}
