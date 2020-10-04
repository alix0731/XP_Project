package kino.xp.project.Controllers;


import kino.xp.project.Model.Movie;
import kino.xp.project.Model.Planner;
import kino.xp.project.Model.Reservation;
import kino.xp.project.Repository.ReservationRepository;
import kino.xp.project.Service.MovieService;
import kino.xp.project.Service.PlannerService;
import kino.xp.project.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    MovieService movieService;

    @Autowired
    PlannerService plannerService;

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("movieList", movieService.listMovies());

        HashMap<String, Integer> movieMap = new HashMap<String, Integer>(); // this maps displays movieReservation by their fullness
        //todo lav metode :


        System.out.println(movieMap.entrySet());

        for (Planner plannedEvent: plannerService.listPlannedMovies())
        {


            int percentageOccupation
                    = reservationRepository  //for each Reservation in the planned event
                    .calculateSeatsReserved
                            (
                            plannedEvent.getTheater_id(),
                            movieService.getMovieById(plannedEvent.getMovie_id()).getTitle(),
                            plannedEvent.getStart_time(),
                            plannedEvent.getStartDate() //todo get proper date
                            );
            //skal teknisk set køre for hver individuel time (i.e. 15, 18 , 21)

            movieMap.put(movieService.getMovieById(plannedEvent.getMovie_id()).getTitle() + "" + plannedEvent.getStart_time(), percentageOccupation);
        }

        System.out.println(movieMap.entrySet());


        model.addAttribute("movieMap", movieMap);

        return "index";
    }
}
