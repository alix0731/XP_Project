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


    @GetMapping("/create-reservations-with-seats/{title}/{playtime}/{date}/{theater}/") //[3]
    public String createReservationWithSeats(@PathVariable("title") String title, @PathVariable("playtime") String playtime,
                                             @PathVariable("date") String date, @PathVariable("theater") int theater,@RequestParam("seats") String seats, Model model){

        model.addAttribute("title", title);
        model.addAttribute("playtime", playtime);
        model.addAttribute("date", date);
        model.addAttribute("theater", theater);

        String[] splitSeats = seats.split(" , ");

        int sum = 0;
        String newSeats ="";

        for (String s:splitSeats)
        {
            if (s.isEmpty())
            {

            }
            else
            {
                String[] sArr = s.split("|");
                sum += Integer.parseInt(sArr[0]);
                System.out.println("s1 = "+sArr[0] + " , s2 = "+sArr[1]);
                System.out.println("sum = "+ sum);
                newSeats+=" , "+sArr[1];
            }
        }

        model.addAttribute("seats", seats);
        model.addAttribute("totalPrice", sum);

        return "reservationPage";
    }





    @GetMapping("/create-reservation/select-seats/{title}/{playtime}/{date}/{theater}") //[2]
    public String selectSeats(@PathVariable("title") String title, @PathVariable("playtime") String playtime,
                              @PathVariable("date") String date, @PathVariable("theater") int theater, Model model)
    {
        List<Reservation> listOfReservationsForSpecificMovie = reservationService.getListOfReservationsByMovieTitleAndPlaytimeAndDate(title, playtime, date);
        model.addAttribute("matrix", new SeatMatrix(theater, listOfReservationsForSpecificMovie));
        model.addAttribute("title", title);
        model.addAttribute("playtime", playtime);
        model.addAttribute("date", date);
        model.addAttribute("theater", theater);

        return "seat-selector";
    }



    @PostMapping("/reservation-created")
    public String reservationCreated(@ModelAttribute Reservation reservation, @RequestParam("seats") String seats){

        String[] splitSeats = seats.split(" , ");
        Reservation rsv = new Reservation();
        rsv.setReservation_id(reservation.getReservation_id());

        for (String seat: splitSeats)
        {



            if (!seat.isEmpty()) {

                rsv.setFirstName(reservation.getFirstName());
                rsv.setLastName(reservation.getLastName());
                rsv.setEmail(reservation.getEmail());
                rsv.setPhoneNumber(reservation.getPhoneNumber());
                rsv.setMovie_date(reservation.getMovie_date());
                rsv.setReservation_date(reservation.getReservation_date());
                rsv.setMovie_playtime(reservation.getMovie_playtime());
                rsv.setTheater_id(reservation.getTheater_id());
                rsv.setMovie_title(reservation.getMovie_title());

                rsv.setSeat_nr(Integer.parseInt(seat));
                reservationService.createReservation(rsv);
                rsv.setReservation_id(rsv.getReservation_id()+1);
            }
        }



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
