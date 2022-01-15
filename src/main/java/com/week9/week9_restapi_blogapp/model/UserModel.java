package com.week9.week9_restapi_blogapp.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;


    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String emailAddress;

    @Column(nullable = false)
    private String password;

    @JoinColumn
    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<UserModel> listOfFriends;

    @JoinColumn
    @ManyToMany
    @JsonManagedReference(value = "favourite")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PostModel> favouritePosts;

    @OneToMany(mappedBy = "userModel")
    private List<PostModel> userPosts = new ArrayList<>();

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", listOfFriends=" + listOfFriends +
                ", favouritePosts=" + favouritePosts +
                ", userPosts=" + userPosts +
                '}';
    }
}
