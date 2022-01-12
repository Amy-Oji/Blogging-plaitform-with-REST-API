package com.week9.week9_restapi_blogapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "post_table")
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn(name = "userPosts")
    private UserModel user;

    @OneToMany(mappedBy = "post")
    private List<CommentModel> listOfComments = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<PostLikes> postLikes = new ArrayList<>();
}
