/**
 * @Edit Emil Norsker 3/10/20: added method for selection of seats.
 */



package kino.xp.project.Controllers;
import kino.xp.project.Model.Reservation;
import kino.xp.project.Model.SeatMatrix;
import kino.xp.project.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    @GetMapping("/create-reservation/select-seats/{title}/{playtime}/{date}/{theater}")
    public String selectSeats(@PathVariable("title") String title, @PathVariable("playtime") String playtime,
                              @PathVariable("date") String date, @PathVariable("theater") int theater, Model model)
    {
        List<Reservation> listOfReservationsForSpecificMovie = reservationService.getListOfReservationsByMovieTitleAndPlaytimeAndDate(title, playtime, date);
        model.addAttribute("matrix", new SeatMatrix(theater, listOfReservationsForSpecificMovie));


        return "seat-selector";
    }

    /*

    @GetMapping("/create-reservation/")
    public String addReservations(@RequestParam("seats") String[] seats,Model model)
    {

        return "seat-selector";
    }


     */
    @GetMapping("/create-reservations/with-seats")
    public String addReservations(@RequestParam("seats") String seats,Model model)
    {
        System.out.println("seats are = " +seats);

        //todo split seats, crete a reervation for each seat


        return "redirect:/";
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


    @GetMapping("")
    public String seatSelector()
    {
        //requires some information about the matrix of seats. ie Matrix = [10, 5] is a room of 10 rows and

        return "seat-selector";
    }



}
