package kino.xp.project.Controllers;

import kino.xp.project.Service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SnackController {

    @Autowired
    SnackService snackService;

    @GetMapping("/addSnack")
    public String addSnack(){

        return "/addSnack";
    }

}
