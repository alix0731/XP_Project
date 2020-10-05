package kino.xp.project.Controllers;

import kino.xp.project.Model.Reservation;
import kino.xp.project.Repository.ReservationRepository;
import kino.xp.project.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Jonas, Jonathan
 * @Parameter controller for metoder relateret til Filter
 * @Output sender browser til den korrekte html side
 **/

@Controller
public class FilterController {

    @Autowired
    ReservationService reservationService;

    @PostMapping(value = "/filterReservation")
    public String getFilter(Model model, @RequestParam("tlf") int tlf)
    {
        try {
            Reservation reservation = reservationService.getReservationByPhonenumber(tlf);
            model.addAttribute("reservation", reservation);
            System.out.println(reservationService.getReservationByPhonenumber(tlf));
            return "filterReservation";
        }catch (Exception e){
            Reservation reservation = new Reservation();
            e.printStackTrace();
            model.addAttribute("reservation", reservation);
            return "filterReservation";
        }
    }

    @PostMapping(value = "/filterReservation/deleteReservation")
    public String deleteReservation(@RequestParam("reservationId") int id)
    {
        System.out.print(id);
        reservationService.deleteReservation(id);
        return "redirect:/";
    }
}
