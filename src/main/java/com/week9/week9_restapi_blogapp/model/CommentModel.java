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
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostModel post;

//    private String comments;

//    @OneToMany
//    private List<CommentLikes> commentLikes = new ArrayList<>();

    public CommentModel(String comment, PostModel post, UserModel user) {
        this.comment = comment;
        this.post = post;
        this.user = user;
    }

    public CommentModel(Long commentId, String comment) {
        this.commentId = commentId;
        this.comment = comment;
    }

}
