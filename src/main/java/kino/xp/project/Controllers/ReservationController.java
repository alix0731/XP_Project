package kino.xp.project.Controllers;

import kino.xp.project.Model.Reservation;
import kino.xp.project.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

//    Ali og Edmond

    @Autowired
    ReservationService reservationService;


    // Laver en getmapping path variable, så man kan hente title og tid fra forsiden til reservations siden
    @GetMapping("/create-reservation{title}/{id}")
    public String createReservation( @PathVariable("title") String title , @PathVariable("id") String playtime, Model model){

        model.addAttribute("title", title);
        model.addAttribute("playtime", playtime);

        return "reservationPage";

    }

    @PostMapping("/reservation-created")
    public String reservationCreated(@ModelAttribute Reservation reservation){


        reservationService.createReservation(reservation);


        return "redirect:/";
    }

    @GetMapping("/Delete-reservation/{reservation_id}")
    public String deleteReservation(@PathVariable ("reservation_id") int id)
    {
        reservationService.deleteReservation(id);

        return "redirect:/";
    }
}
