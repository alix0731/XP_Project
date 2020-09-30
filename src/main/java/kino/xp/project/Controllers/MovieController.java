package kino.xp.project.Controllers;

import kino.xp.project.Model.Movie;
import kino.xp.project.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author Jacqques, Daniel, Emil Andersen
 * @Parameter controller for metoder relateret til Movie-objekter
 * @Output sender browser til den korrekte html side og diverse metodekald
 **/

@Controller
public class MovieController
{
    String path = "movieTemplates/";
    @Autowired
    MovieService movieService;

    @GetMapping("/CreateMovie")
    public String createMovie()
    {
        movieService.listMovies();
        return path + "CreateMovie";
    }

    @PostMapping("/CreateMovie")
    public String createMovie(@ModelAttribute Movie movie)
    {
        movieService.addMovieToDatabase(movie);
        return "/index";
    }

    @GetMapping("/ListMovies")
    public String listMovies(Model model)
    {
        List<Movie> movieList = movieService.listMovies();
        model.addAttribute("movieList", movieList);
        return path + "ListMovies";
    }

    @GetMapping("/DeleteMovie/{movie_id}")
    public String deleteMovie(@PathVariable("movie_id") int id)
    {
        movieService.deleteMovieFromDatabase(id);
        return "redirect:/ListMovies";
    }

    @GetMapping("/UpdateMovie/{movie_id}")
    public String updateMovie(@PathVariable("movie_id") int id, Model model)
    {
        Movie m = movieService.getMovieById(id);
        model.addAttribute("movie", m);
        return path + "UpdateMovie";
    }

    @PostMapping("/UpdateMovie")
    public String updateMovie(@ModelAttribute Movie movie)
    {
        movieService.updateMovieInDatabase(movie);
        return "redirect:/ListMovies";
    }
}
