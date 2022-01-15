//package com.week9.week9_restapi_blogapp.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@Entity(name = "likeComment_table")
//@NoArgsConstructor
//@AllArgsConstructor
//public class CommentLikes {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long commentLikeId;
//
//
//    @ManyToOne
//    @JoinColumn(name = "commentLikes_comment")
//    private CommentModel comment;
//
//    @ManyToOne
//    @JoinColumn(name = "commentLikes_user")
//    private UserModel user;
//}
