package kino.xp.project.Controllers;

import kino.xp.project.Model.Snack;
import kino.xp.project.Service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

@Controller
public class SnackController {

    @Autowired
    SnackService snackService;

    @GetMapping("/addSnack")
    public String addSnack(){

        return "/addSnack";
    }

    @PostMapping("addSnack")
    public String addedSnack(@RequestParam Map<String,String> allReqeustParam){
        System.out.println(allReqeustParam);
        snackService.addSnack(new Snack(allReqeustParam.get("name"),Integer.parseInt(allReqeustParam.get("price")),allReqeustParam.get("img")));
        System.out.println(Arrays.toString(snackService.getSnacks().toArray()));
        return "redirect:/";
    }


    @GetMapping("/AllSnacks")
    public String allSnacks(){
        return "AllSnacks";
    }

}
