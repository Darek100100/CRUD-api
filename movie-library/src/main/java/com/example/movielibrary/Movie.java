package com.example.movielibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {   //class represent retriving from database
    private int id;
    private String name;
    private int rating;
}
