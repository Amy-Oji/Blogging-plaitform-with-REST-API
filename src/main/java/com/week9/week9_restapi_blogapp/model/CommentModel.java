package com.week9.week9_restapi_blogapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "postComment_post")
    private PostModel post;

    @ManyToOne
    @JoinColumn(name = "postComment_user")
    private UserModel user;

    private String comments;

    @OneToMany
    private List<CommentLikes> commentLikes = new ArrayList<>();

}
