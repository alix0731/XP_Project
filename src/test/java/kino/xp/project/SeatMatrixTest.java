package kino.xp.project;

import kino.xp.project.Model.Reservation;
import kino.xp.project.Model.SeatMatrix;
import kino.xp.project.Service.MovieService;
import kino.xp.project.Service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class SeatMatrixTest
{

    @Autowired
    ReservationService reservationService;



    @Test
   public void getMatrix()
   {
       List<Reservation> listOfReservationsForSpecificMovie = reservationService.getListOfReservationsByMovieTitleAndPlaytimeAndDate("The Call Of The Wild", "21-00" , "1997-04-15");

       SeatMatrix matrix = new SeatMatrix(1,  listOfReservationsForSpecificMovie);

       Reservation[] firstRow = matrix.getMatrix().get(0); // gets the reservation at seat 1



       assert firstRow[0].getFirstName().equals("test");


   }


}
