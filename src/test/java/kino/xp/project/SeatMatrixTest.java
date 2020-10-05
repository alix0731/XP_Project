package kino.xp.project;

import kino.xp.project.Model.Reservation;
import kino.xp.project.Model.SeatMatrix;
import kino.xp.project.Service.MovieService;
import kino.xp.project.Service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SeatMatrixTest
{

    @Autowired
    ReservationService reservationService;



    @Test
   public void getMatrix()
   {
       //create availiable seats


       //date is for testing and will have specific entries in the DB.

       List<Reservation> listOfReservationsForSpecificMovie = reservationService.getListOfReservationsByMovieTitleAndPlaytimeAndDate("Shrek10", "18-00" , "2020-10-04");

       SeatMatrix matrix = new SeatMatrix(1,  listOfReservationsForSpecificMovie);

       Reservation[] secondRow = matrix.getMatrix().get(1); // gets the reservation at seat 1

       System.out.println(secondRow[8].getSeat_nr());
       //assert secondRow[8].getFirstName().equals("Hans");

       //reservation ligger på plads 24, hvilket er den 8. plads i række 2.
   }


}
