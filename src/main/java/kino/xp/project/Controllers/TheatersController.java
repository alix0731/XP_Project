/*
package kino.xp.project.Controllers;

import kino.xp.project.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheatersController {

    @Autowired
    TheaterService theaterService;

    @GetMapping("/")
    public String index(Model model) {
       model.addAttribute("theater", theaterService.listTheaters());
        return "index";
    }
}

*/