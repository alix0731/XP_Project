package kino.xp.project.Controllers;

import kino.xp.project.Model.Movie;
import kino.xp.project.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author Jacqques, Daniel, Emil Andersen
 * @Parameter controller for metoder relateret til Movie-objekter
 * @Output sender browser til den korrekte html side og diverse metodekald
 **/

@Controller
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/CreateMovie")
    public String createMovie() {
        movieService.listMovies();
        return "CreateMovie";
    }

    @PostMapping("/CreateMovie")
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.addMovieToDatabase(movie);
        return "/index";
    }

    /*@GetMapping("/ListMovies")
    public String*/
}
