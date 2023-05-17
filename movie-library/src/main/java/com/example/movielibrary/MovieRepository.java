package com.example.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MovieRepository { //class responsible to communcation from database
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Movie> getAll() {  //methode to return all from db
       return jdbcTemplate.query("SELECT id, name, rating FROM movie",
                BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public Movie getById(int id){ //methode to return one movie from db
        return jdbcTemplate.queryForObject("SELECT id FROM movie, name ,rating WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Movie.class), id);

    }

}