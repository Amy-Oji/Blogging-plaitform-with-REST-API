package com.week9.week9_restapi_blogapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FavoritePost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

}
