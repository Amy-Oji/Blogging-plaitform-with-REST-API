//package com.week9.week9_restapi_blogapp.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@Entity(name = "postLike_table")
//@NoArgsConstructor
//@AllArgsConstructor
//public class PostLikes {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long postLikeId;
//
//
//    @ManyToOne
//    @JoinColumn(name = "post")
//    private PostModel post;
//
//    @ManyToOne
//    @JoinColumn(name = "postLikes_user")
//    private UserModel user;
//}
