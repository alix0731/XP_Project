package kino.xp.project.Controllers;

import kino.xp.project.Model.Schedule;
import kino.xp.project.Model.Worker;
import kino.xp.project.Service.MovieService;
import kino.xp.project.repositories.RandomMethod;
import kino.xp.project.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * @Author Jonas, Jonathan
 * @Parameter controller for metoder relateret til Statistik
 * @Output sender browser til den korrekte html side
 **/

@Controller
public class StatisticController {

    ScheduleRepository sr = new ScheduleRepository();
    @Autowired
    MovieService movieService;

    @GetMapping("/statistic")
    public String getStat(Model model)
    {
        RandomMethod rm1film1 = new RandomMethod(1);
        RandomMethod rm1film2 = new RandomMethod(1);
        RandomMethod rm1film3 = new RandomMethod(1);
        RandomMethod rm1film4 = new RandomMethod(1);
        model.addAttribute("film1", rm1film1.getArrayList());
        model.addAttribute("film2", rm1film2.getArrayList());
        model.addAttribute("film3", rm1film3.getArrayList());
        model.addAttribute("film4", rm1film4.getArrayList());
        model.addAttribute("movieList", movieService.listMovies());
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

    @RequestMapping(value = "/schedule/{weekNr}", method = RequestMethod.GET)
    public String getSchedule(@PathVariable int weekNr, Model model, ModelMap map)
    {
        map.addAttribute("WorkerList", sr.readAllWorkers());
        model.addAttribute("ScheduleList", sr.readScheduleByWeek(weekNr));
        return "schedule";
    }

    @RequestMapping(value = "/schedule/{weekNr}/{dayNr}/{type}", method = RequestMethod.GET)
    public String getWorkerList(@PathVariable String weekNr, @PathVariable String dayNr, @PathVariable String type, Model model)
    {
        Schedule tempSched = new Schedule(Integer.parseInt(weekNr), Integer.parseInt(dayNr), type);
        model.addAttribute("schedule", tempSched);
        model.addAttribute("workers", sr.readAllWorkersList());
        return "workerListAdd";
    }

    @PostMapping(value = "/schedule/add")
    public String addWorker(@RequestParam String weekNr, @RequestParam String dayNr, @RequestParam String type, @RequestParam String workerId)
    {
        System.out.println(weekNr+""+dayNr+""+workerId+""+type);
        int tempWeek = Integer.parseInt(weekNr);
        int tempDay = Integer.parseInt(dayNr);
        int tempWorker= Integer.parseInt(workerId);
        System.out.println(tempWeek+""+tempDay+""+tempWorker);
        switch (type)
        {
            case "worker1_id" : sr.addSale1(tempWeek,tempDay,tempWorker); break;
            case "worker2_id" : sr.addSale2(tempWeek,tempDay,tempWorker); break;
            case "movieO_id" : sr.addMovieO(tempWeek,tempDay,tempWorker); break;
            case "ticketO_id" : sr.addTicketO(tempWeek,tempDay,tempWorker); break;
        }
        return "redirect:/schedule/" + weekNr;
    }

    @GetMapping("workerList")
    public String getWorkerList(Model model)
    {
        model.addAttribute("workers", sr.readAllWorkersList());
        return "workerList";
    }

    @PostMapping(value = "/workerList/remove")
    public String delWorker(@RequestParam int id)
    {
        sr.delete(id);
        return "redirect:/workerList";
    }

    @GetMapping("workerList/create")
    public String createWorker()
    {
        return "createWorker";
    }

    @PostMapping(value = "/create/do")
    public String createWorkerDo(@RequestParam String name)
    {
        sr.create(new Worker(name));
        return "redirect:/workerList";
    }
}
