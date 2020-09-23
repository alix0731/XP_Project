package kino.xp.project.Controllers;

import kino.xp.project.Model.Movie;
import kino.xp.project.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/CreateMovie")
    public String createMovie() {
        return "CreateMovie";
    }

    @PostMapping("/CreateMovie")
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.addMovieToDatabase(movie);
        return "/index";
    }
}
