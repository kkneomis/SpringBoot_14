package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectorRepository directorRepository;

    @RequestMapping("/")
    public String index(Model model){
        //Creating a director
        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        //Create a movie
        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About Stars");

        //Add movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        //Create a movie
        movie = new Movie();
        movie.setTitle("GOT: he movie");
        movie.setYear(2013);
        movie.setDescription("Dragons and ish");
        movies.add(movie);

        //add movies to the director's movies
        director.setMovies(movies);
        //Save director
        directorRepository.save(director);


        //push to viewd
        model.addAttribute("directors", directorRepository.findAll());
        return "index";
    }


}
