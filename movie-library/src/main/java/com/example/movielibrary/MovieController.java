package com.example.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("")
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @GetMapping("/{id}")
    public Movie GetById(@PathVariable("id") int id) {
        return movieRepository.getById(id);
    }

    @PostMapping("")
        public int add(@RequestBody List<Movie> movies) {
            return movieRepository.save(movies);
        }

    @PutMapping("/{id}")
        public int update(@PathVariable("id") int id, @RequestBody Movie updateMovie) {
        Movie movie = movieRepository.getById(id);

        if(movie != null) {
            movie.setName(updateMovie.getName());
            movie.setRating(updateMovie.getRating());

            movieRepository.update(movie);

            return 1;
        } else {
            return -1;
        }
    }
 }
