package kino.xp.project.Controllers;

import kino.xp.project.Model.Reservation;
import kino.xp.project.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/create-reservation")
    public String createReservation(){


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
