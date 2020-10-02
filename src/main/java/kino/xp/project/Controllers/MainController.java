package kino.xp.project.controllers;


import kino.xp.project.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    MovieService movieService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("movieList", movieService.listMovies());

        return "index";
    }
}
