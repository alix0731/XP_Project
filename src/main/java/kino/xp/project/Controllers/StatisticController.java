package kino.xp.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @Author Jonas, Jonathan
 * @Parameter controller for metoder relateret til Statistik
 * @Output sender browser til den korrekte html side
 **/

@Controller
public class StatisticController {

    @PostMapping("/statistic")
    public String getLogin(){
        return "statistic";
    }
}
