package com.week9.week9_restapi_blogapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity(name = "post_table")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserModel userModel;


    @OneToMany(mappedBy = "post")
    private List<CommentModel> listOfComments;   //new ArrayList<>();

    @JoinColumn
    @OneToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<UserModel> postLikes;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn
    @JsonBackReference(value = "favourite")
    private UserModel userFavourites;

    @Override
    public String toString() {
        return "PostModel{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
//                ", userModel=" + userModel +
                ", listOfComments=" + listOfComments +
//                ", postLikes=" + postLikes +
                ", userFavourites=" + userFavourites +
                '}';
    }

}
