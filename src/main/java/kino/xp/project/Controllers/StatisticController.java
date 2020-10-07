package kino.xp.project.Controllers;

import kino.xp.project.Service.MovieService;
import kino.xp.project.repositories.RandomMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author Jonas, Jonathan
 * @Parameter controller for metoder relateret til Statistik
 * @Output sender browser til den korrekte html side
 **/

@Controller
public class StatisticController {

    @Autowired
    MovieService movieService = new MovieService();

    @GetMapping("/statistic")
    public String getStat(Model model)
    {
        model.addAttribute("movieList", movieService.listMovies());
        RandomMethod rm = new RandomMethod(movieService.listMovies().size());
        model.addAttribute("randomNumber", rm.getArrayList());
        return "statistic";
    }

    @GetMapping(value = "/calendar")
    public String getCalendar(Model model)
    {
        RandomMethod rm14sal11 = new RandomMethod(7);
        RandomMethod rm14sal12 = new RandomMethod(7);
        RandomMethod rm14sal21 = new RandomMethod(7);
        RandomMethod rm14sal22 = new RandomMethod(7);
        model.addAttribute("sal11", rm14sal11.getArrayList());
        model.addAttribute("sal12", rm14sal12.getArrayList());
        model.addAttribute("sal21", rm14sal21.getArrayList());
        model.addAttribute("sal22", rm14sal22.getArrayList());
        return "calendar";
    }
}
