package kino.xp.project;

import kino.xp.project.Model.Reservation;
import kino.xp.project.Model.SeatMatrix;

import java.util.ArrayList;

public class ReservationTest
{




    public void getMatrix()
    {
        //create availiable seats


        //3x3 matrix

        //date is for testing and will have specific entries in the DB.
        SeatMatrix matrix = new SeatMatrix("15-04-97", "test", 1, "test");

        Reservation[] firstRow = matrix.getMatrix().get(0); // gets the reservation at seat 1

        assert firstRow[0].getFirstName() == "norskerTest";



    }


}
