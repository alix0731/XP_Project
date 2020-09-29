package kino.xp.project.controllers;


import kino.xp.project.Model.Movie;
import kino.xp.project.Repository.TestList;
import kino.xp.project.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class MainController {

    TestList testList = new TestList();
    MovieService movieService = new MovieService();


    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("list", testList.getList());




        return "index";
    }
}
