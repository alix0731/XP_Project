package kino.xp.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticController {

    @GetMapping("/login/statistic")
    public String getLogin(){
        return "statistic";
    }
}
