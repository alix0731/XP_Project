package kino.xp.project.Controllers;

import kino.xp.project.Model.Snack;
import kino.xp.project.Service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class SnackController {

    @Autowired
    SnackService snackService;

    @GetMapping("/addSnack")
    public String addSnack(){

        return "/snack/addSnack";
    }

    @PostMapping("addSnack")
    public String addedSnack(@RequestParam Map<String,String> allReqeustParam){
        System.out.println(allReqeustParam);
        snackService.addSnack(new Snack(allReqeustParam.get("name"),Integer.parseInt(allReqeustParam.get("price")),allReqeustParam.get("img")));
        System.out.println(Arrays.toString(snackService.getSnacks().toArray()));
        return "redirect:/";
    }

    @GetMapping("/snack")
    public String snackMain(Model model){
        model.addAttribute("snackList" , snackService.getSnacks());
        System.out.println(Arrays.toString(snackService.getSnacks().toArray()));
        return "/snack/snackMain";
    }

    @PostMapping("/selectedSnacks")
    public String selectedSnacks(@RequestParam Map<String,String> allRequestParam,Model model){
        System.out.println( "hh:" + (allRequestParam));
        List<Snack> snackList = snackService.getSnacks();

        double totalPris = 0;
        for (Snack snack : snackList){
            if (!allRequestParam.get(snack.getProduct_id()+"").equals("")){
                System.out.println(allRequestParam.get(snack.getProduct_id()+""));
                totalPris += snack.getProduct_price() *  Double.parseDouble(allRequestParam.get(snack.getProduct_id()+""));
            }
        }
        model.addAttribute("totalPris", totalPris);

        //direct to a total to pay page.
        System.out.println(totalPris);
        //why you didn't work before, I wouldn't know.....................
        return "snack/snackPrice";
    }


    @GetMapping("/AllSnacks")
    public String allSnacks(Model model){



        model.addAttribute("list", snackService.getAll());

        return "AllSnacks";
    }

    @PostMapping("/deleteSnack")
    public String deleteSnack(@RequestParam int id){
        snackService.deleteSnack(id);
        return "redirect:/AllSnacks";
    }


    @GetMapping("/editSnack{id}")
    public String edit(@PathVariable("id") int id, Model model){

        System.out.println(id);
        Snack snack = snackService.getById(id);
        System.out.println(snack.getProduct_name());

        model.addAttribute("id", snack.getProduct_id());
        model.addAttribute("name", snack.getProduct_name());
        model.addAttribute("price", snack.getProduct_price());
        model.addAttribute("img", snack.getProduct_img());


        return "snack/EditSnack";
    }

    @PostMapping("/updateSnack")
    public String update(Snack snack){

        snackService.editSnack(snack);

        return "redirect:/editSnack";
    }

}
